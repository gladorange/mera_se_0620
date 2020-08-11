package course.objects;

import course.xmlannotations.XmlName;
import course.xmlannotations.XmlTypeName;
import course.xmlannotations.XmlIgnore;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@XmlTypeName("Person")
public class Passenger {
    @XmlIgnore
    public static String DEFAULT_FIRST_NAME = "NoFirstName";
    @XmlIgnore
    public static String DEFAULT_LAST_NAME = "NoLastName";
    @XmlIgnore
    public static Integer DEFAULT_AGE = -1;
    @XmlIgnore
    public static Integer DEFAULT_DOCUMENT_NUMBER = -1;
    @XmlIgnore
    public static Boolean DEFAULT_HAS_TICKET = false;

    //@XmlIgnore
    private Integer tokenId;
    @XmlName("Name")
    private String firstName;
    @XmlName("Surname")
    private String lastName;
    @XmlName("Age")
    private Integer age;
    //@XmlIgnore
    private Integer documentNumber;
    //@XmlIgnore
    private boolean hasTicket;

    public Passenger() {
        this.tokenId = ThreadLocalRandom.current().nextInt();
        this.firstName = DEFAULT_FIRST_NAME;
        this.lastName = DEFAULT_LAST_NAME;
        this.age = DEFAULT_AGE;
        this.documentNumber = DEFAULT_DOCUMENT_NUMBER;
        this.hasTicket = DEFAULT_HAS_TICKET;
    }

    public Passenger(Integer tokenId, String firstName, String lastName, Integer age, Integer documentNumber, Boolean hasTicket) {
        this.tokenId = tokenId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.documentNumber = documentNumber;
        this.hasTicket = hasTicket;
    }

    public Integer getTokenId() {
        return tokenId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public Boolean getHasTicket() {
        return hasTicket;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setHasTicket(Boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    @Override
    public String toString() {
        return "Passenger {\n" +
                "\t\"tokenId\" : " + tokenId + ",\n" +
                "\t\"firstName\" : \"" + firstName + "\",\n" +
                "\t\"lastName\" : \"" + lastName + "\",\n" +
                "\t\"age\" : " + age + ",\n" +
                "\t\"documentNumber\" : " + documentNumber + ",\n" +
                "\t\"hasTicket\" : " + hasTicket + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(tokenId, passenger.tokenId) &&
                Objects.equals(firstName, passenger.firstName) &&
                Objects.equals(lastName, passenger.lastName) &&
                Objects.equals(age, passenger.age) &&
                Objects.equals(documentNumber, passenger.documentNumber) &&
                Objects.equals(hasTicket, passenger.hasTicket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tokenId, firstName, lastName, age, documentNumber, hasTicket);
    }
}