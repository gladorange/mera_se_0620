package com.mera.lesson5.persons;

public class Person {


    String name;
    String surname;


    public static class IncorrectNameException extends RuntimeException {
        final String incorrectName;
        public IncorrectNameException(String message, String incorrectName) {
            super(message);
            this.incorrectName = incorrectName;
        }
    }

    /**
     *
     * @param name
     * @param surname
     * @throws RuntimeException если Имя не англйиское
     */
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        checkName(name);
        checkName(surname);

    }



    public void checkName(String text) {
        for (char c : text.toCharArray()) {
            if (c > 'z' || c < 'A') {
                final IncorrectNameException incorrectNameException = new IncorrectNameException("Символ " + c + " не является английсиким в имени " + text, text);
                throw incorrectNameException;
            }
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
