package com.mera.lesson5;

import java.util.Locale;
import java.util.Random;

public class TextField extends Rectangle {
    String text = generateString();

    public TextField(int x, int y, int width, int height, String caption) {
        super(x, y, width, height, caption);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws ReadOnlyException {
        if (!isTurnedOn()) {
            throw new ReadOnlyException();
        }
        this.text = text;
    }

    private String generateString() {
        int lengthTextString = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String charsForString = characters + characters.toLowerCase(Locale.ROOT);
        StringBuilder textString = new StringBuilder();

        for (int i = 0; i < lengthTextString; i++) {
            textString.append(charsForString.charAt(new Random().nextInt(charsForString.length())));
        }
        return textString.toString();
    }

    public static String getTypeName(){
        return "Текстовое поле";
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
