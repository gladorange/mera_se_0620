package com.mera.task5.ui.text;

import com.mera.task5.geometry.Point;
import com.mera.task5.geometry.Rectangle;
import com.mera.task5.ui.Element;
import com.mera.task5.ui.ReadOnlyException;

public class TextField extends Element {

    public static final String TEXT_FIELD_TYPE_NAME = "Текстовое поле";

    private String text = "";

    public TextField(Rectangle geometry, String caption) {
        super(geometry, caption);
    }

    public TextField(Point topLeft, int width, int height, String caption) {
        super(topLeft, width, height, caption);
    }

    public TextField(Point topLeft, int width, int height) {
        super(topLeft, width, height);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(isEnabled()) {
            this.text = text;
        }
        else {
            throw new ReadOnlyException("Элемент " + TEXT_FIELD_TYPE_NAME + " заблокирован!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(TEXT_FIELD_TYPE_NAME);
        sb.append(buildDescription());
        return sb.toString();
    }
}
