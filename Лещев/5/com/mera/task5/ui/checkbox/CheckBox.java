package com.mera.task5.ui.checkbox;

import com.mera.task5.geometry.Point;
import com.mera.task5.geometry.Rectangle;
import com.mera.task5.ui.Clickable;
import com.mera.task5.ui.Element;
import com.mera.task5.ui.ReadOnlyException;

public class CheckBox extends Element implements Clickable {

    public static final String CHECK_BOX_TYPE_NAME = "Галка";

    private boolean isChecked = false;

    public CheckBox(Rectangle geometry, String caption) {
        super(geometry, caption);
    }

    public CheckBox(Point topLeft, int width, int height, String caption) {
        super(topLeft, width, height, caption);
    }

    public CheckBox(Point topLeft, int width, int height) {
        super(topLeft, width, height);
    }

    @Override
    public void click() {
        if(isEnabled()) {
            isChecked = !isChecked;
        }
        else {
            throw new ReadOnlyException("Элемент " + CHECK_BOX_TYPE_NAME + " заблокирован!");
        }
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(CHECK_BOX_TYPE_NAME);
        sb.append(buildDescription());
        return sb.toString();
    }
}
