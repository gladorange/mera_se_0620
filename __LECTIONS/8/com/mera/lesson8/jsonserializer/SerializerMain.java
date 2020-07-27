package com.mera.lesson8.jsonserializer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class SerializerMain {


    public static void main(String[] args) throws IllegalAccessException {
        ShopItem apples = new ShopItem("Яблоко", 20, "Продукты", 23471234);
        ShopItem bread = new ShopItem("Хлеб", 10, "Продукты", 231233);

        List<ShopItem> items = Arrays.asList(apples, bread);


        System.out.println(serialize(items));

        // [
        //
        // {
        //      "name": "Яблоко"
        //      "quantity":20
        //      "category":"Продукты"
        // }
        // ,
        // {
        //      "name": "Хлеб"
        //      "quantity":10
        //      "category":"Продукты"
        // }
        // ,
        // ]


    }


    static String serialize(List<? extends Object> items) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder("[");

        for (Object item : items) {
            sb.append("{");


            for (Field field : item.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonIgnore.class)) {
                    continue;
                }

                field.setAccessible(true);

                String prefix = "";
                String suffix = "";

                if (field.getType() == String.class) {
                    prefix = "\"";
                    suffix = "\"";
                }

                String fieldValue = prefix + field.get(item) + suffix;

                final String name = getFieldName(field);
                sb.append("\"" + name + "\"" + ":" + fieldValue + ",");
            }

            sb.append("}");
        }

        sb.append("]");
        return sb.toString();
    }

    private static String getFieldName(Field field) {

        final JsonName annotation = field.getAnnotation(JsonName.class);
        if (annotation == null) {
            return field.getName();
        }


        final String value = annotation.value();
        if (!value.isEmpty()) {
            return value;
        }
        return field.getName();
    }
}
