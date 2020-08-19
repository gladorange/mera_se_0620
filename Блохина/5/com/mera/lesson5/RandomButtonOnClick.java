package com.mera.lesson5;

public class RandomButtonOnClick implements ButtonClickCallback {
    int buttonIndex;

    public RandomButtonOnClick(int buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    @Override
    public void onButtonClick() throws NumberFormatException {
        System.out.println("Нажата случайная Кнопка" + buttonIndex);
    }

    @Override
    public String toString() {
        return "RandomButtonOnClick{" +
                "buttonIndex=" + buttonIndex +
                '}';
    }
}