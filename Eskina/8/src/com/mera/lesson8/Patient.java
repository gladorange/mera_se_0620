package com.mera.lesson8;

import java.util.Objects;

@XmlTypeName("Пациент")
public class Patient {
    public static final String EMPTY_STRING = "";

    @XmlName("Имя")
    protected String name;

    @XmlName("Фамилия")
    protected String surname;

    @XmlIgnore
    protected Integer age;

    @XmlName("Номер телефона")
    protected String phoneNumber;

    public Patient() {
        name = EMPTY_STRING;
        surname = EMPTY_STRING;
        phoneNumber = EMPTY_STRING;
        age = 0;
    }

    public Patient(String name, String surname, Integer age, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name) &&
                Objects.equals(surname, patient.surname) &&
                Objects.equals(age, patient.age) &&
                Objects.equals(phoneNumber, patient.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, phoneNumber);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


}
