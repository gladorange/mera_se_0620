public class AnotherPerson {

    private String firstName;
    @XmlName("Отчество")
    private String parentName;
    @XmlName("Фамилия")
    private String secondName;

    protected int childrenNumber;

    @XmlIgnore
    public boolean hasFriend;

    public AnotherPerson() {
        this("Иван","Иваныч","Иванов", 0, false);
    }

    public AnotherPerson(String firstName, String parentName, String secondName, int childrenNumber, boolean hasFriend) {
        this.firstName = firstName;
        this.parentName = parentName;
        this.secondName = secondName;
        this.childrenNumber = childrenNumber;
        this.hasFriend = hasFriend;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public boolean isHasFriend() {
        return hasFriend;
    }

    public void setHasFriend(boolean hasFriend) {
        this.hasFriend = hasFriend;
    }

    @Override
    public String toString() {
        return "AnotherPerson{" +
                "firstName='" + firstName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", childrenNumber=" + childrenNumber +
                ", hasFriend=" + hasFriend +
                '}';
    }
}
