package com.mera.task5.ui.button;

import com.mera.task5.ui.Element;
import com.mera.task5.geometry.Point;
import com.mera.task5.geometry.Rectangle;
import com.mera.task5.ui.Clickable;
import com.mera.task5.ui.ReadOnlyException;

public class Button extends Element implements Clickable {

    public static final String BUTTON_TYPE_NAME = "Кнопка";
    private ButtonClickCallback callback;

    public Button(Point topLeft, int width, int height, ButtonClickCallback callback) {
        super(topLeft, width, height);
        setCallback(callback);
    }

    public Button(Point topLeft, int width, int height, String caption, ButtonClickCallback callback) {
        super(topLeft, width, height, caption);
        setCallback(callback);
    }

    public Button(Rectangle geometry, String caption, ButtonClickCallback callback) {
        super(geometry, caption);
        setCallback(callback);
    }

    public Button(Rectangle geometry, String caption) {
        super(geometry, caption);
    }

    @Override
    public void click() {
        if(callback == null) {
            System.out.println("There is no callback for this button!");
            return;
        }
        if(isEnabled()) {
            callback.onButtonClick();
        }
        else {
            throw new ReadOnlyException("Элемент " + BUTTON_TYPE_NAME + " заблокирован!");
        }
    }

    public void setCallback(ButtonClickCallback callback) {
        if(callback == null) {
            throw new IllegalArgumentException("Button callback must be not null!");
        }
        this.callback = callback;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(BUTTON_TYPE_NAME);
        sb.append(buildDescription());
        return sb.toString();
    }
}
