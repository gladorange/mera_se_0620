package com.mera.lesson5;

import java.util.List;

public class MainOfInterface {
    public static void main(String[] args) throws ReadOnlyException, ElementsOverlapException {
        UI scene = new UI();

        TextField textFieldX = new TextField(5,5, 20, 10, "textFieldX");
        TextField textFieldY = new TextField(5,20, 20, 10, "textFieldY");
        Button addElementButton = new Button(5, 35, 15, 10, "Добавить элемент", new AddElementOnClick(scene, textFieldX, textFieldY));
        try {
            scene.add(textFieldX);
            scene.add(textFieldY);
            scene.add(addElementButton);
        } catch (ElementsOverlapException e){
            System.out.println(e.getMessage());
            return;
        }

        for (int i = 0; i < 2; i++) {
            String randomX = String.valueOf(Rectangle.getRandom(UI.MAX_WIDTH_SCENE));
            String randomY = String.valueOf(Rectangle.getRandom(UI.MAX_HEIGHT_SCENE));
            try {
                textFieldX.setText(randomX);
                textFieldY.setText(randomY);
            } catch (ReadOnlyException e) {
                System.out.println(e.getMessage());
            }
            addElementButton.click();
        }

        List<Rectangle> elements = scene.getAllElements();

        System.out.println("\nСписок элементов:");
        for (Rectangle element : elements) {
            System.out.println(element);
        }

        System.out.println("\nКликаем на элементы, кроме кнопки 'Добавить элемент':");
        for (Rectangle element : elements) {
            if (element instanceof Clickable) {
                if (!element.equals(addElementButton)) {
                    ((Clickable) element).click();
                    if (element instanceof CheckBox) {
                        String state = ((CheckBox)element).isChecked ? "нажата" : "не нажата";
                        System.out.println("Состояние после нажатия: " + element.getCaption() + " " + state);
                    }
                }
            }
        }

        System.out.println("\nТекст в текстовых полях:");
        for (Rectangle element : elements) {
            if (element instanceof TextField) {
                System.out.println(element.getCaption() + ", текст = '" + ((TextField)element).getText() + "'");
            }
        }
    }
}
