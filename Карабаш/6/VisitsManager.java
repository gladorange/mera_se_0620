import java.util.*;

public class VisitsManager {

    private Set<Triple<Person, Date, String>> visitSet = new HashSet<>();
    private List<Triple<Person, Date, String>> visitList = new ArrayList<>();

    public Set<Triple<Person, Date, String>> getVisitSet() {
        return visitSet;
    }

    public List<Triple<Person, Date, String>> getVisitList() {
        return visitList;
    }

    public void printVisitSet() {
        for (Triple<Person, Date, String> triple : visitSet) {
            System.out.println(triple.getFirst() + ", " + triple.getSecond() + ", " + triple.getThird());
        }
    }

    public void generateVisits(List<Person> people, List<String> locations) {
        final Random random = new Random();

        final int NUM_VISITS_PER_MAN = 300;
        Month[] allMonths = Month.values();

        for ( Person person : people ) {
            for (int i = 0; i < NUM_VISITS_PER_MAN; i++) {
                String randomPlace = locations.get(random.nextInt(locations.size()));
                Month randomMonth = allMonths[random.nextInt(allMonths.length)];
                Date randomDate = new Date(random.nextInt(randomMonth.getMaxDay())+1, randomMonth, 2020);
                Triple<Person, Date, String> visitRecord = new Triple<>(person,randomDate, randomPlace);
                visitSet.add(visitRecord);
                visitList.add(visitRecord);
            }
        }
    }

    public boolean isListAndSetSameLength(){
        return visitSet.size() == visitList.size();
    }

    /*
Задача - сгенерировать случайный список посещений используя
HashSet<Triple<Person,Date,String>>
и
List<Triple<Person,Date,String>>


String в данном случае - это место посещения.
 Один человек может посещать одно и то же место два раза в один день.
 Но должна быть возможность просто вывести список, без дубликатов.

 Создайте 5 разных человек.
 Определите 3 разных места, которые могут посещать люди (например: дом, работа, библиотка)
 Пусть каждый человек посетит 300 мест в случайные даты в течение одного года.

 Запишите каждое посещение, используя тройку: человек, дата, место в HashSet и в List
 Если размеры List'a и Set'a  совпадают - выведите на экран надпись "Ни один человек не посещал одно и то же место два раза в один день".

 Иначе - ничего не выводите.

         */
}
