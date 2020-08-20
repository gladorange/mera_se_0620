import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DeserializeFromXML {
    static public Object deserialize(String stringOfObjects, Class<?> className) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException{
        XmlTypeName typeNameAnnotation = className.getAnnotation(XmlTypeName.class);

        String openClassTagName = Lesson8Utils.getOpenTagName(typeNameAnnotation.value());
        String closeClassTagName = Lesson8Utils.getCloseTagName(typeNameAnnotation.value());

        final int startIndex = stringOfObjects.indexOf(openClassTagName);
        final int endIndex = stringOfObjects.indexOf(closeClassTagName);

        Object newObject = className.getDeclaredConstructor().newInstance();

        String stringToParse = stringOfObjects.substring(startIndex, endIndex).replace(openClassTagName, "");

        Map<String,String> fieldsMap = createMapWithFields(stringToParse);

        initFields(fieldsMap, className.getDeclaredFields(), newObject);

        return newObject;
    }

    public static Map<String,String> createMapWithFields(String stringToParse) {
        Map<String,String> fields = new HashMap<>();

        String[] tagStrings = stringToParse.split("\n\t");
        for (String tagString : tagStrings) {
            int startElementOfTag = tagString.indexOf("<");
            int endElementOfTag = tagString.indexOf("</");
            if ((startElementOfTag < 0) || (endElementOfTag < 0)) {
                continue;
            }
            String[] pair = tagString.substring(startElementOfTag, endElementOfTag).replace("<", "").split(">");
            if (pair.length == 2) {
                fields.put(pair[0], pair[1]);
            }
        }
        return fields;
    }

    public static void initFields(Map<String, String> fieldsMap, Field[] fields, Object newObject) throws IllegalAccessException {
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
