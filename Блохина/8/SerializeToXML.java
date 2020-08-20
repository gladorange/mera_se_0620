import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;

public class SerializeToXML {
    static public String serialize(Collection<?> object) throws IllegalAccessException {
        StringBuilder serializeString = new StringBuilder();

        for (Object o : object) {
            XmlTypeName typeNameAnnotation = o.getClass().getAnnotation(XmlTypeName.class);
            serializeString.append(Lesson8Utils.getOpenTagName(typeNameAnnotation.value()) + "\n");

            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                XmlName nameAnnotation = field.getAnnotation(XmlName.class);
                XmlIgnore ignoreAnnotation = field.getAnnotation(XmlIgnore.class);
                if ((nameAnnotation != null) && (ignoreAnnotation == null)) {
                    serializeString.append("\t" + Lesson8Utils.getOpenTagName(nameAnnotation.value()) );
                    serializeString.append(field.get(o).toString());
                    serializeString.append(Lesson8Utils.getCloseTagName(nameAnnotation.value()) + "\n");
                }
            }

            serializeString.append(Lesson8Utils.getCloseTagName(typeNameAnnotation.value()) + "\n");
        }

        return serializeString.toString();
    }

}
