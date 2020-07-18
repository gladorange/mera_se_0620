package com.mera.lesson5;

public class Rectangle {

    protected Point topLeft;
    protected int height;
    protected int width;

    public Rectangle(Point topLeft, int height, int width) {
        this.topLeft = topLeft;
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point getTopLeft() {
        return topLeft;
    }
}
