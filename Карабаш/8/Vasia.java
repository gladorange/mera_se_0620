@XmlTypeName("Василий")
public class Vasia {

    @XmlName("Имя")
    String firstName="Vasya";

    @XmlName("Возраст")
    double age=12;

    @XmlIgnore
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Vasia{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
