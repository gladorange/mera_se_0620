package com.mera.lesson8;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericExample {


    static class GenericClass {
        public List<String> field;
    }

    public static void main(String[] args) throws NoSuchFieldException {

        final Class<GenericClass> genericClassClass = GenericClass.class;
        final Type field = genericClassClass.getField("field").getGenericType();
        if (field instanceof ParameterizedType) {
            final Type[] actualTypeArguments = ((ParameterizedType) field).getActualTypeArguments();
            System.out.println(actualTypeArguments[0]);
        }

    }
}
