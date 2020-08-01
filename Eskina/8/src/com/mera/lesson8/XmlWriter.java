package com.mera.lesson8;

import java.lang.reflect.Field;
import java.util.Collection;

public class XmlWriter {
    static public String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        for(Object object : objects) {
            try{
                stringBuilder.append(serializeObject(object));
            } catch(TypeNameAnnotationNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println(object.getClass() +"object couldn't be serialized ");
            }
        }
        return stringBuilder.toString();
    }
    static public StringBuilder serializeObject(Object object) throws TypeNameAnnotationNotFoundException, IllegalAccessException {
        //format of serialization:
        // <Человек>
        //    <Имя>Vasya</Имя>
        //    <Возраст>12</Возраст>
        //</Человек>
        StringBuilder stringBuilder = new StringBuilder();
        XmlTypeName classNameAnnotation = object.getClass().getAnnotation(XmlTypeName.class);
        if (classNameAnnotation == null) {
            throw new TypeNameAnnotationNotFoundException();
        }
        stringBuilder.append(getOpenTagName(classNameAnnotation.value()) + "\n");
        //Get declared fields of the object.
        //In case if XmlName annotation is included
        //and XmlIgnore isn't, put tagName and the value of the field into the string
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            XmlName nameAnnotation = field.getAnnotation(XmlName.class);
            XmlIgnore ignoreAnnotation = field.getAnnotation(XmlIgnore.class);
            if ((nameAnnotation != null) && (ignoreAnnotation == null)) {
                stringBuilder.append("\t" + getOpenTagName(nameAnnotation.value()) );
                stringBuilder.append(field.get(object).toString());
                stringBuilder.append(getCloseTagName(nameAnnotation.value()) + "\n");
            }
        }
        stringBuilder.append(getCloseTagName(classNameAnnotation.value()) + "\n");
        return stringBuilder;
    }

    static public String getOpenTagName(String tagName) {
        return "<" + tagName + ">";
    }

    static public String getCloseTagName(String tagName) {
        return "</" + tagName + ">";
    }
}
