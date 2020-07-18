package com.mera.lesson5;


public class TextField extends Element {
    public final static String TEXT = "0";
    public static final String CAPTION = "Текстовое поле";

    public String text;

    public TextField() {
        super();
        elType = ElementType.TEXT_FIELD;
        text = TEXT;
        caption = CAPTION;
    }

    public TextField(Rectangle rect, String caption, String text) {
        super(rect, ElementType.TEXT_FIELD);
        this.caption = caption.isEmpty() ? CAPTION : caption;

        if (text.isEmpty()) {
            text = TEXT;
        } else {
            this.text = checkText(text) ? text : TEXT;
        }
    }

    public String getText() {
        return text;
    }

    public int getNumberFromText() {
        return Integer.valueOf(text);
    }

    //return true if text is correct: includes only number
    public boolean checkText(String text) {
        try{
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Введенный текст должен быть числом!");
            return false;
        }
    }

    public void setText(String text) {
        this.text = checkText(text) ? text : TEXT;
    }
}
