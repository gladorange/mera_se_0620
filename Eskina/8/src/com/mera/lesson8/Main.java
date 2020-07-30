package com.mera.lesson8;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, TypeNameAnnotationNotFoundException {
        Collection<Object> objects = new ArrayList<>();
        //for testing create a collection with 6 objects:
        //first - class is provided with XmlTypeName annotation, all the fields include XmlType annotation
        Book book = new Book("Сто лет одиночества", "Г.Г. Маркес", 500, true);
        //second - class is provided with XmlTypeName annotation,all the fields apart from one include XmlType annotation, one includes XmlIgnore annotation
        Patient patient = new Patient("Иван", "Иванов", 33, "1234512345");
        //third - class is provided with XmlTypeName annotation, all the fields have XmlIgnore annotation
        Meal pizza = new Meal("Pepperoni", 666);
        //forth - there are no any annotations
        Film film = new Film("Сабрина", 1974, true);
        //fifth - class isn't provided with XmlTypeName annotation, one field has XmlType annotation
        Country country = new Country("Россия", 144_000_000);
        //sixth - only XmlTypeName annotation exists
        Animal animal = new Animal("Собака", "Косточка");

        objects.add(book);
        objects.add(patient);
        objects.add(pizza);
        objects.add(film);
        objects.add(country);
        objects.add(animal);
        String serializedObjects = XmlWriter.serialize(objects);
        System.out.println(serializedObjects);
        try {
            Book deserializedBook = (Book) XmlParser.deserializeObject(serializedObjects, Book.class);
            System.out.println(deserializedBook);
            Meal deserializedMeal = (Meal) XmlParser.deserializeObject(serializedObjects, Meal.class);
            System.out.println(deserializedMeal);
            Patient deserializedPatient = (Patient) XmlParser.deserializeObject(serializedObjects, Patient.class);
            System.out.println(deserializedPatient);
            //TypeNameAnnotationNotFoundException should be thrown
            Country deserializedCountry = (Country) XmlParser.deserializeObject(serializedObjects, Country.class);
            System.out.println(deserializedCountry);
        } catch (ObjectNotFoundException | TypeNameAnnotationNotFoundException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Animal deserializedAnimal = (Animal) XmlParser.deserializeObject(serializedObjects, Animal.class);
            System.out.println(deserializedAnimal);
            //TypeNameAnnotationNotFoundException should be thrown
            Film deserializedFilm = (Film) XmlParser.deserializeObject(serializedObjects, Film.class);
            System.out.println(deserializedFilm);
        } catch (ObjectNotFoundException | TypeNameAnnotationNotFoundException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            //check the ObjectNotFoundException will be thrown as the object wasn't serialized
            Fruit fruit = (Fruit) XmlParser.deserializeObject(serializedObjects, Fruit.class);
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
