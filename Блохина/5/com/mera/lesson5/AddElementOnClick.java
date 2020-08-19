package com.mera.lesson5;

import java.util.Random;

public class AddElementOnClick implements  ButtonClickCallback{
    UI scene;
    TextField xTextField;
    TextField yTextField;

    public AddElementOnClick(UI scene, TextField xTextField, TextField yTextField) {
        this.scene = scene;
        this.xTextField = xTextField;
        this.yTextField = yTextField;
    }

    @Override
    public void onButtonClick() throws ElementsOverlapException, ReadOnlyException {
        Rectangle toAdd = generateRandomElement();
        scene.add(toAdd);
    }

    private Rectangle generateRandomElement() throws ReadOnlyException {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());
        int elementId = scene.getCount();
        switch (Rectangle.getRandom(3)) {
            case 0:
                return new Button(x, y, 20, 10, Button.getTypeName() + elementId, new RandomButtonOnClick(elementId));
            case 1:
                CheckBox checkBox = new CheckBox(x, y, 10, 10, CheckBox.getTypeName() + elementId);
                if(!new Random().nextBoolean()){
                    checkBox.setChecked(false);
                }
                return checkBox;
            case 2:
                return new TextField(x, y, 30, 10, TextField.getTypeName() + elementId);
            default:
                return null;
        }
    }
}
