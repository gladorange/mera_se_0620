package com.mera.lesson8.annotations;

import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;


public class AnnotationsSample {


    class MyList extends ArrayList {

        @Override
        public int size() {
            return super.size();
        }


    }


    @Override
    public String toString() {
        return "AnnotationsSample{" +
                "someField='" + someField + '\'' +
                ", anotherField='" + anotherField + '\'' +
                '}';
    }

    @NotNullableField
    String someField;

    String anotherField;


    public static void main(String[] args) throws IllegalAccessException {
        final AnnotationsSample goodSample = new AnnotationsSample();
        goodSample.someField = "a";

        final AnnotationsSample badSample = new AnnotationsSample();
        badSample.anotherField = "1";


     //   validate(goodSample);
        validate(badSample);

    }

    private static void validate(Object toCheck) throws IllegalAccessException {
        final Class<?> aClass = toCheck.getClass();
        for (Field declaredField : aClass.getDeclaredFields()) {
            if (declaredField.getAnnotation(NotNullableField.class) != null) {
                declaredField.setAccessible(true);
                if (declaredField.get(toCheck) == null) {
                    throw new IllegalArgumentException("Значение поле "
                            + declaredField.getName() +" не может быть null на объекте " + toCheck);
                }
            }
        }

    }


}
