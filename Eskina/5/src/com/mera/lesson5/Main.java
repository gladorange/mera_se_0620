package com.mera.lesson5;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws ElementsOverlapException, ReadOnlyException {
        UI scene = new UI();
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        //create Button
        Button firstButton = new Button(new AddElementOnClick(scene));
        firstButton.setRect(new Rectangle(new Point(0,0), 10, 10));
        firstButton.setCaption("Добавить элемент");
        try {
            scene.addElement(firstButton);
        } catch (ElementsOverlapException | ElementOversizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Создали кнопку " + firstButton.toString());

        //create 2 text fields including coordinates of new elements
        TextField textFirst = new TextField();
        textFirst.setRect(new Rectangle(new Point(0,20), 10, 10));
        textFirst.setCaption("x");
        try {
            scene.addElement(textFirst);
        } catch (ElementsOverlapException | ElementOversizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Создали Текстовое поле " + textFirst.toString());

        TextField textSecond = new TextField();
        textSecond.setRect(new Rectangle(new Point(20,20), 10, 10));
        textSecond.setCaption("y");
        try {
            scene.addElement(textSecond);
        } catch (ElementsOverlapException | ElementOversizeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Создали Текстовое поле " + textSecond.toString());

        System.out.println("\n Начинаем создание элементов\n");
        for(int i = 0; i < 10; i++) {
            //fill text fields with random numbers 0-100
            textFirst.setText(String.valueOf(rand.nextInt(100)));
            textSecond.setText(String.valueOf(rand.nextInt(100)));

            //set coordinates for new element given from the textfield
            scene.setX(textFirst.getNumberFromText());
            scene.setY(textSecond.getNumberFromText());
            firstButton.click();
        }

        System.out.println("\n Добавлены элементы\n");
        Element[] elements = scene.getAllElements();
        for (int i = 0; i < elements.length; i++) {
            Element el = elements[i];
            System.out.println(el.toString());
            switch(el.getElType()) {
                case BUTTON -> { if (!el.getCaption().equals("Добавить элемент")) {
                    ((Button)el).click();
                }
                }
                case CHECK_BOX -> {
                    ((Checkbox)el).click();
                }
                case TEXT_FIELD -> {
                    System.out.println("Текстовое поле " + ((TextField)el).getText());
                }
            }
        }
    }
}