@XmlTypeName("Актер")
public class Actor {

    @XmlName("Имя")
    String firstName = "Олег";
    @XmlName("Возраст")
    double age = 65;
    @XmlIgnore
    String password;

    public Actor() {
        firstName = "";
    }

    public Actor(String firstName, double age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
