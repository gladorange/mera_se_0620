package com.mera.lesson5;

public class CheckBox extends Rectangle implements Clickable{
    boolean isChecked;

    public CheckBox(int x, int y, int width, int height, String caption) {
        super(x, y, width, height, caption);
        this.isChecked = true;
    }

    @Override
    public void click() throws ElementsOverlapException, ReadOnlyException {
        isChecked = !isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) throws ReadOnlyException {
        if (!isTurnedOn()) {
            throw new ReadOnlyException();
        }
        isChecked = checked;
    }

    public static String getTypeName() {
        return "Галка";
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
