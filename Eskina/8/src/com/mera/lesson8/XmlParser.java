package com.mera.lesson8;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {

    static public Object deserializeObject(String stringOfObjects, Class<?> className) throws TypeNameAnnotationNotFoundException, ObjectNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (stringOfObjects == null) {
            throw new NullPointerException();
        }

        XmlTypeName classNameAnnotation = className.getAnnotation(XmlTypeName.class);
        if (classNameAnnotation == null) {
            throw new TypeNameAnnotationNotFoundException();
        }

        String openClassTagName = XmlWriter.getOpenTagName(classNameAnnotation.value());
        String closeClassTagName = XmlWriter.getCloseTagName(classNameAnnotation.value());

        final int startIndex = stringOfObjects.indexOf(openClassTagName);
        final int endIndex = stringOfObjects.indexOf(closeClassTagName);

        //if XmlTypeName annotation for the required class isn't presented in serialized string
        if ((startIndex < 0) || (endIndex < 0)) {
            throw new ObjectNotFoundException();
        }

        //XmlTypeName annotation exists, so
        //create a new object for the specified class name
        Object newObject = className.getDeclaredConstructor().newInstance();

        //remove tag with XmlTypeName value from the parsing string
        String stringToParse = stringOfObjects.substring(startIndex, endIndex).replace(openClassTagName, "");

        //if fields are not presented in serialized string
        //return the object without any additional field's initialization
        if (stringToParse.isEmpty()) {
            return newObject;
        }
        //divide the string included serialized information into pairs "XmlType annotation value-field value"
        //and put it into the map
        Map<String,String> fieldsMap = createFieldsMap(stringToParse);

        initializeFields(fieldsMap, className.getDeclaredFields(), newObject);

        return newObject;
    }

    public static Map<String,String> createFieldsMap(String stringToParse) {
        Map<String,String> fieldsMap = new HashMap<>();

        String[] tagStrings = stringToParse.split("\n\t");
        for (String str : tagStrings) {
            int start = str.indexOf("<");
            int end = str.indexOf("</");
            if ((start < 0) || (end < 0)) {
                continue;
            }
            String[] pair = str.substring(start, end).replace("<", "").split(">");
            if (pair.length == 2) {
                fieldsMap.put(pair[0], pair[1]);
            }
        }
        return fieldsMap;
    }

    public static void initializeFields(Map<String, String> fieldsMap, Field[] fields, Object newObject) throws IllegalAccessException {
        for (Field field : fields) {
            field.setAccessible(true);
            XmlName nameAnnotation = field.getAnnotation(XmlName.class);
            if ((nameAnnotation!= null) && (fieldsMap.containsKey(nameAnnotation.value()))) {
                String valueToSet = fieldsMap.get(nameAnnotation.value());

                if (isBooleanField(field.getType())) {
                    field.set(newObject, Boolean.valueOf(valueToSet));
                }
                if (isIntegerField(field.getType())) {
                    field.set(newObject, Integer.valueOf(valueToSet));
                }
                if (isStringField(field.getType())) {
                    field.set(newObject, valueToSet);
                }
            }
        }
    }

    static boolean isIntegerField(Class<?> className) {
        return (className == Integer.class) || (className == int.class);
    }

    static boolean isBooleanField(Class<?> className) {
        return (className == Boolean.class) || (className == boolean.class);
    }

    static boolean isStringField(Class<?> className) {
        return (className == String.class);
    }
}
