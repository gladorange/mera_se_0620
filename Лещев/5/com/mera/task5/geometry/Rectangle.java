package com.mera.task5.geometry;

import java.util.Objects;

/**
 * @class Rectangle in left-to-right, top-to-bottom coordinate system
 */
public class Rectangle {
    private final Point topLeft;
    private final int width;
    private final int height;

    public static boolean hasIntersection(Rectangle first, Rectangle second) {
        if(first.equals(second)) {
            return true;
        }
        Point[] firstVertexes = calculateVertexes(first);
        for(Point vertex : firstVertexes) {
            if(isPointInRectangle(vertex, second)) {
                return true;
            }
        }
        Point[] secondVertexes = calculateVertexes(second);
        for(Point vertex : secondVertexes) {
            if(isPointInRectangle(vertex, first)) {
                return true;
            }
        }
        return false;
    }

    public Rectangle(Point topLeft, int width, int height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        int w = bottomRight.getX() - topLeft.getX();
        if(w < 0) {
            throw new IllegalArgumentException("Bottom right point's X should be greater than top left point's X.");
        }
        else {
            this.width = w;
        }
        int h = bottomRight.getY() - topLeft.getY();
        if(h < 0) {
            throw new IllegalArgumentException("Bottom right point's Y should be greater than top left point's Y.");
        }
        else {
            this.height = h;
        }
    }

    public Rectangle(Rectangle other) {
        this.topLeft = other.topLeft;
        this.width = other.width;
        this.height = other.height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width &&
                height == rectangle.height &&
                topLeft.getX() == rectangle.topLeft.getX() &&
                topLeft.getY() == rectangle.topLeft.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, width, height);
    }

    private static Point[] calculateVertexes(Rectangle rect) {
        Point[] vertexes = new Point[4];
        vertexes[0] = rect.getTopLeft();
        vertexes[1] = new Point(vertexes[0].getX() + rect.getWidth(), vertexes[0].getY());
        vertexes[2] = new Point(vertexes[1].getX(), vertexes[1].getY() + rect.getHeight());
        vertexes[3] = new Point(vertexes[0].getX(), vertexes[2].getY());
        return vertexes;
    }

    private static boolean isPointInRectangle(Point point, Rectangle rect) {
        Point bottomRight = new Point(rect.getTopLeft().getX() + rect.width
                                      , rect.getTopLeft().getY() + rect.height);
        if(point.getX() >= rect.getTopLeft().getX() && point.getX() <= bottomRight.getX()) {
            if(point.getY() >= rect.getTopLeft().getY() && point.getY() <= bottomRight.getY()) {
                return true;
            }
        }
        return false;
    }
}
