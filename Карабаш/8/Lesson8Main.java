import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lesson8Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Vasia vasia = new Vasia();
        vasia.setPassword("123");

        System.out.println("Создан объект 'Вася': "+vasia);
        System.out.println("Сериализация Васи...");
        String serialized = Serializer.serialize(Arrays.asList(vasia));
        System.out.println("Результат сериализации:");
        System.out.println(serialized);
        System.out.println("----");

        System.out.println("Десериализация Васи...");
        List<Vasia> vasias = Serializer.deserialize(serialized, Vasia.class);
        Vasia vasia2 = null;
        if(vasias != null){
            vasia2 = vasias.get(0);
        }
        System.out.println("Результат: "+vasia2);

        System.out.println("----");

        AnotherPerson[] notIvanovy = new AnotherPerson[2];
        notIvanovy[0] = new AnotherPerson();
        notIvanovy[0].setFirstName("Николай");
        notIvanovy[0].setParentName("Николаич");
        notIvanovy[0].setSecondName("Петров");
        notIvanovy[0].setChildrenNumber(2);
        notIvanovy[0].setHasFriend(true);

        notIvanovy[1] = new AnotherPerson();
        notIvanovy[1].setFirstName("Семён");
        notIvanovy[1].setParentName("Семёныч");
        notIvanovy[1].setSecondName("Никоноров");
        notIvanovy[1].setChildrenNumber(3);
        notIvanovy[1].setHasFriend(true);

        System.out.println("Создан список (неИвановых): ");
        System.out.println(notIvanovy[0]);
        System.out.println(notIvanovy[1]);
        System.out.println("Сериализация неИвановых...");

        String serialized2 = Serializer.serialize(Arrays.asList(notIvanovy));
        System.out.println("Результат сериализации:");
        System.out.println(serialized2);
        System.out.println("----");

        System.out.println("Десериализация неИвановых...");
        List<AnotherPerson> notIvaniovy2 = Serializer.deserialize(serialized2, AnotherPerson.class);
        System.out.println("Результат: ");
        if(notIvaniovy2 == null){
            System.out.println("null");
        } else {
            for (int i = 0; i < notIvaniovy2.size(); i++) {
                AnotherPerson notIvan2 = notIvaniovy2.get(i);
                if(notIvan2 == null){
                    System.out.println("Объект["+i+"]: null");
                } else{
                    System.out.println("Объект["+i+"]: "+notIvan2);
                }
            }
        }
        System.out.println("----");
        System.out.println("End.");
    }
}
