package com.mera.lesson5;

import java.util.concurrent.ThreadLocalRandom;

public class AddElementOnClick implements ButtonClickCallback {
    protected UI scene;

    public AddElementOnClick(UI scene) {
        this.scene = scene;
    }

    public void setScene(UI scene) {
        this.scene = scene;
    }

    public UI getScene() {
        return scene;
    }

    @Override
    public void onButtonClick() {
        Element toAdd = generateRandomElement();
        try {
            scene.addElement(toAdd);
        } catch (ElementsOverlapException | ElementOversizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Element generateRandomElement() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        ElementType elType = ElementType.generateRandomType();

        // check coordinates of the left top point were given from the textfield
        int x = scene.getX();
        int y = scene.getY();
        Point point;
        if ((x == -1) && (y == -1)) {
            point = new Point(rand.nextInt(UI.SCENE_WIDTH), rand.nextInt(UI.SCENE_HEIGHT));
        } else {
            point = new Point(x,y);
            scene.setDefaultCoordinates();
        }

        //width and height of the element are random in bounds 1-10
        Rectangle rect  = new Rectangle(point, rand.nextInt(1, 11), rand.nextInt(1, 11));

        switch (elType) {
            case BUTTON:
                return new Button(rect, Element.EMPTY_STRING, new AddElementOnClick(scene));
            case CHECK_BOX:
                return new Checkbox(rect, Element.EMPTY_STRING, rand.nextBoolean());
            case TEXT_FIELD:
                try {
                    return new TextField(rect, Element.EMPTY_STRING, Element.EMPTY_STRING);
                } catch (NumberFormatException e) {
                    System.out.println("Не могу добавить [Текстовое поле]: введенный текст не является числом!");
                }
        }
        return null;
    }

}
