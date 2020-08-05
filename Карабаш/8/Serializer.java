import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Serializer {

    final static char LINE_BREAK = '\n';
    final static String INDENT_4_SPACES = "    ";

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder outString = new StringBuilder();

        for (Object object : objects) {
            Class<?> objClass = object.getClass();

            try {
                objClass.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                System.out.println("Объект " + objClass.getName() + " не имеет контруктора по умолчанию, не сериализован.");
                continue;
            }
            if (outString.length() > 0) {
                outString.append(LINE_BREAK);
            }
            String className = getClassName(objClass);
            outString.append(getOpenTag(className));
            outString.append(LINE_BREAK);
            int indentLevel = 1;
            for (Field field : objClass.getDeclaredFields()) {

                String fieldName = getFieldName(field);
                if (fieldName == null) {
                    continue; // skip this field
                }
                field.setAccessible(true);

                Class<?> fieldClass = field.getType();
                if (!(fieldClass.equals(String.class) ||
                        fieldClass.equals(Long.class) ||
                        fieldClass.equals(long.class) ||
                        fieldClass.equals(Integer.class) ||
                        fieldClass.equals(int.class) ||
                        fieldClass.equals(Character.class) ||
                        fieldClass.equals(char.class) ||
                        fieldClass.equals(Boolean.class) ||
                        fieldClass.equals(boolean.class) ||
                        fieldClass.equals(Double.class) ||
                        fieldClass.equals(double.class))) {
                    System.out.println("Объект " + objClass.getName() +
                            ": Тип поля " + fieldName + " не в списке сериализуемых - пропущено.");
                    continue;
                }

                String fieldValue = field.get(object).toString();

                outString.append(getIndentByLevel(indentLevel));
                outString.append(getOpenTag(fieldName));
                outString.append(fieldValue);
                outString.append(getClosingTag(fieldName));
                outString.append(LINE_BREAK);
            }
            //indentLevel = 0;
            outString.append(getClosingTag(className));
        }
        return outString.toString();
    }

    public static String getFieldName(Field field) {
        String fieldName = null;
        for (Annotation annotation : field.getDeclaredAnnotations()) {
            if (annotation instanceof XmlIgnore) {
                return null;
            }
            if (annotation instanceof XmlName) {
                fieldName = ((XmlName) annotation).value();
            }
        }
        if (fieldName == null || fieldName.isEmpty()) {
            fieldName = field.getName();
        }
        return fieldName;
    }

    public static String getClassName(Class<?> objClass) {
        String className = null;
        if (objClass.isAnnotationPresent(XmlTypeName.class)) {
            XmlTypeName xmlTypeName = objClass.getAnnotation(XmlTypeName.class);
            className = xmlTypeName.value();
        }
        if (className == null || className.isEmpty()) {
            className = objClass.getName();
        }
        return className;
    }

    private static StringBuilder getOpenTag(String name) {
        return getTag(name, false);
    }

    private static StringBuilder getClosingTag(String name) {
        return getTag(name, true);
    }

    private static StringBuilder getTag(String name, boolean isClosing) {
        StringBuilder out = new StringBuilder();
        out.append('<');
        if (isClosing) {
            out.append('/');
        }
        out.append(name);
        out.append('>');
        return out;
    }

    private static StringBuilder getIndentByLevel(int indentLevel) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < indentLevel; i++) {
            out.append(INDENT_4_SPACES);
        }
        return out;
    }

    public static <T> List<T> deserialize(String xmlDataAsString, Class<T> objectClass) throws IllegalAccessException, InstantiationException {

        try {
            objectClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            System.out.println("Объект " + objectClass.getName() + " не имеет контруктора по умолчанию, десериализация отменена.");
            return null;
        }

        String className = getClassName(objectClass);
        String xmlClassOpenTag = getOpenTag(className).toString();
        String xmlClassClosingTag = getClosingTag(className).toString();

        List<T> resultCollection = new ArrayList<>();
        int lastSeen = 0;
        boolean foundAny = false;
        while (lastSeen < xmlDataAsString.length()) {
            int startPos = xmlDataAsString.indexOf(xmlClassOpenTag, lastSeen);
            if (startPos < 0 || startPos < lastSeen) {
                if (!foundAny) {
                    System.out.println("Не найден тэг " + xmlClassOpenTag + " во входной строке, десериализация отменена.");
                    return null;
                } else {
                    break;
                }
            }
            int endPos = xmlDataAsString.indexOf(xmlClassClosingTag, startPos);
            if (endPos < 0 || endPos < startPos) {
                if (!foundAny) {
                    System.out.println("Не найден тэг " + xmlClassClosingTag + " во входной строке, десериализация отменена.");
                    return null;
                } else {
                    break;
                }
            }
            startPos += xmlClassOpenTag.length();
            lastSeen = endPos + xmlClassClosingTag.length();
            if (startPos > endPos) {
                //System.out.println("Не найдены данные между тэгами " + xmlClassOpenTag + " и " + xmlClassClosingTag
                //                            + " во входной строке, блок пропущен.");
                continue;
            }
            String xmlData = xmlDataAsString.substring(startPos, endPos);
            T object = objectClass.newInstance();

            for (Field field : objectClass.getDeclaredFields()) {

                String fieldName = getFieldName(field);
                if (fieldName == null) {
                    continue; //skip this field
                }
                field.setAccessible(true);

                Class<?> fieldClass = field.getType();
                if (!(fieldClass.equals(String.class) ||
                        fieldClass.equals(Long.class) ||
                        fieldClass.equals(long.class) ||
                        fieldClass.equals(Integer.class) ||
                        fieldClass.equals(int.class) ||
                        fieldClass.equals(Character.class) ||
                        fieldClass.equals(char.class) ||
                        fieldClass.equals(Boolean.class) ||
                        fieldClass.equals(boolean.class) ||
                        fieldClass.equals(Double.class) ||
                        fieldClass.equals(double.class))) {
                    //System.out.println("Тип поля " + fieldName + " не в списке сериализуемых - пропущено.");
                    continue;
                }
                //String fieldValue = field.get(object).toString();
                String fieldOpenTag = getOpenTag(fieldName).toString();
                String fieldCloseTag = getClosingTag(fieldName).toString();
                startPos = xmlData.indexOf(fieldOpenTag);
                if (startPos >= 0) {
                    endPos = xmlData.indexOf(fieldCloseTag, startPos);
                }
                if (startPos < 0 || endPos < 0 || startPos + fieldOpenTag.length() >= endPos) {
                    //System.out.println("Данные для поля " + fieldName + " не найдены. Оставлено значение по умолчанию.");
                    continue;
                }
                startPos += fieldOpenTag.length();
                //endPos--;
                String fieldValue = xmlData.substring(startPos, endPos);
                if (fieldClass.equals(String.class)) {
                    field.set(object, fieldValue);
                } else if (fieldClass.equals(Integer.class) || fieldClass.equals(int.class)) {
                    field.setInt(object, Integer.parseInt(fieldValue));
                } else if (fieldClass.equals(Long.class) || fieldClass.equals(long.class)) {
                    field.setLong(object, Long.parseLong(fieldValue));
                } else if (fieldClass.equals(Character.class) || fieldClass.equals(char.class)) {
                    field.setChar(object, fieldValue.charAt(0));
                } else if (fieldClass.equals(Boolean.class) || fieldClass.equals(boolean.class)) {
                    field.setBoolean(object, Boolean.parseBoolean(fieldValue));
                } else if (fieldClass.equals(Double.class) || fieldClass.equals(double.class)) {
                    field.setDouble(object, Double.parseDouble(fieldValue));
                }
            }
            resultCollection.add(object);
            foundAny = true;
        }
        return (resultCollection.isEmpty()) ? null : resultCollection;
    }
}
