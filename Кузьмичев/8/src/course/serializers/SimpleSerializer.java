package course.serializers;

import course.xmlannotations.XmlName;
import course.xmlannotations.XmlTypeName;
import course.xmlannotations.XmlIgnore;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class SimpleSerializer {
    public static String xmlSerialize(Collection<?> objects) throws IllegalAccessException {
        if (objects.isEmpty()) {
            throw new IllegalStateException("Simple Serializer Exception: Objects collection is empty.");
        }

        StringBuilder xmlString = new StringBuilder();

        for (Object object : objects) {
            xmlString.append("<" + getXmlTypeName(object.getClass()) + ">\n");

            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(XmlIgnore.class)) {
                    continue;
                }

                field.setAccessible(true);

                xmlString.append("\t");
                xmlString.append("<" + getXmlName(field) + ">");
                xmlString.append(field.get(object));
                xmlString.append("</" + getXmlName(field) + ">\n");
            }

            xmlString.append("</" + getXmlTypeName(object.getClass()) + ">\n");
        }

        return xmlString.toString();
    }

    private static String getXmlTypeName(Class<?> clazz) {
        if (clazz.isAnnotationPresent(XmlTypeName.class)) {
            return clazz.getAnnotation(XmlTypeName.class).value();
        }

        return clazz.getSimpleName();
    }

    private static String getXmlName(Field field) {
        if (field.isAnnotationPresent(XmlName.class)) {
            return field.getAnnotation(XmlName.class).value();
        }

        return field.getName();
    }

    public static Collection<Object> xmlDeserialize(String xmlString, HashSet<Class> classes) throws IllegalAccessException, InstantiationException {
        if (xmlString.isEmpty()) {
            throw new IllegalStateException("Simple Serializer Exception: XML string is empty.");
        }

        if (classes.isEmpty()) {
            throw new IllegalStateException("Simple Serializer Exception: Classes set is empty.");
        }

        Collection<Object> objects = new ArrayList<>();

        do {
            Object newObject = new Object();
            Field[] objectFields = new Field[0];

            Integer xmlClassSectionStart = xmlString.length();
            Integer xmlClassSectionEnd = xmlString.length();

            Boolean isObjectExist = false;

            for (Class clazz : classes) {
                String className = getXmlTypeName(clazz);
                String classTagStart = "<" + className + ">";
                String classTagEnd = "</" + className + ">";

                if (xmlString.indexOf(classTagStart) < xmlClassSectionStart && xmlString.contains(classTagEnd)) {
                    xmlClassSectionStart = xmlString.indexOf(classTagStart);
                    xmlClassSectionEnd = xmlString.indexOf(classTagEnd) + classTagEnd.length();

                    newObject = clazz.newInstance();
                    objectFields = clazz.getDeclaredFields();

                    isObjectExist = true;
                }
            }

            if (!isObjectExist) {
                break;
            }

            String xmlOneClassSection = xmlString.substring(0, xmlClassSectionEnd);

            xmlString = xmlString.substring(xmlClassSectionEnd);

            for (Field field : objectFields) {
                String startTag = "<" + getXmlName(field) + ">";
                String endTag = "</" + getXmlName(field) + ">";

                if (!xmlOneClassSection.contains(startTag) || !xmlOneClassSection.contains(endTag)) {
                    continue;
                }

                field.setAccessible(true);

                String fieldValue = xmlOneClassSection.substring(
                        xmlOneClassSection.indexOf(startTag) + startTag.length(),
                        xmlOneClassSection.indexOf(endTag));

                if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                    field.set(newObject, Boolean.valueOf(fieldValue));
                    continue;
                }

                if (field.getType() == int.class || field.getType() == Integer.class) {
                    field.set(newObject, Integer.valueOf(fieldValue));
                    continue;
                }

                if (field.getType() == String.class) {
                    field.set(newObject, fieldValue);
                }
            }

            objects.add(newObject);
        } while (true);

        return objects;
    }
}