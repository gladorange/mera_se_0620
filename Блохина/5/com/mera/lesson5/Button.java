package com.mera.lesson5;

public class Button extends Rectangle implements Clickable{
    ButtonClickCallback callback;

    public Button(int x, int y, int width, int height, String caption, ButtonClickCallback callback) {
        super(x, y, width, height, caption);
        this.callback = callback;
    }

    @Override
    public void click() throws ElementsOverlapException, ReadOnlyException {
        callback.onButtonClick();
    }

    public static String getTypeName() {
        return "Кнопка";
    }

    @Override
    public String toString() {
        return getTypeName() + "{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", caption='" + caption + "'" +
                '}';
    }
}
