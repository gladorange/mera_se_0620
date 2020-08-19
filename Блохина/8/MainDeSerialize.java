import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class MainDeSerialize {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        Collection<Object> object = new ArrayList<>();

        Actor actor = new Actor("Андрей", 46, "Mironov41");

        object.add(actor);
        String serializeObject = SerializeToXML.serialize(object);
        System.out.println(serializeObject);

        Actor deserializeObject = (Actor) DeserializeFromXML.deserialize(serializeObject, Actor.class);
        System.out.println(deserializeObject);
    }
}
