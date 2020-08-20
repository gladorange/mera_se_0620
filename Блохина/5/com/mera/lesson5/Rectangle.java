package com.mera.lesson5;

import java.util.Random;

public class Rectangle {
    protected int x, y, width, height;
    protected String caption;
    protected boolean isTurnedOn;

    public Rectangle(int x, int y, int width, int height, String caption) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.caption = caption;
        isTurnedOn = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws ReadOnlyException {
        if (!isTurnedOn) {
            throw new ReadOnlyException();
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws ReadOnlyException {
        if (!isTurnedOn) {
            throw new ReadOnlyException();
        }
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws ReadOnlyException {
        if (!isTurnedOn) {
            throw new ReadOnlyException();
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws ReadOnlyException {
        if (!isTurnedOn) {
            throw new ReadOnlyException();
        }
        this.height = height;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) throws ReadOnlyException {
        if (!isTurnedOn) {
            throw new ReadOnlyException();
        }
        this.caption = caption;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    public static int getRandom(int i) {
        return new Random().nextInt(i);
    }

    public static String getTypeName() {
        return "Элемент";
    }

}
