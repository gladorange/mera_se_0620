package com.mera.lesson5;

public class UI {
    public static final int SCENE_WIDTH = 100;
    public static final int SCENE_HEIGHT = 100;
    Rectangle windowSize;
    Element[] elements;
    protected int xCoord;
    protected int yCoord;

    public UI() {
        windowSize = new Rectangle(new Point(0,0), SCENE_WIDTH, SCENE_HEIGHT);
        xCoord = -1;
        yCoord = -1;
    }

    public void setX(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getX() {
        return xCoord;
    }

    public void setY(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getY() {
        return yCoord;
    }

    public void setDefaultCoordinates() {
        xCoord = -1;
        yCoord = -1;
    }

    public Element[] getAllElements() {
        return elements;
    }

    public boolean addElement(Element toAdd) throws ElementsOverlapException, ElementOversizeException {
        if (toAdd == null) {
            System.out.println("Не могу добавить элемент, он не существует.");
            return false;
        }

        //first element is added
        if (elements == null) {
            elements = new Element[]{toAdd};
            return true;
        }

        if (isElementOversized(toAdd.getRect())) {
            throw new ElementOversizeException(toAdd.toString() + " не убирается в заданном поле!");
        }

        //check if the element to be added doesn't overlap existing elements
        for (int i = 0; i < elements.length; i++) {
            if (elementsOverlap(toAdd.getRect(), elements[i].getRect())) {
                throw new ElementsOverlapException(toAdd.toString() + " пересекается с " + elements[i].toString());
            }
        }

        //otherwise add element
        // by coping old elements plus the element to add into a new array
        Element[] newElements = new Element[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        newElements[newElements.length - 1] = toAdd;
        elements = newElements;

        return true;
    }

    public boolean isElementOversized(Rectangle elRect) {
        int maxX = elRect.getTopLeft().getX() + elRect.getWidth();
        int maxY = elRect.getTopLeft().getY() + elRect.getHeight();
        return ((maxX > SCENE_WIDTH) || (maxY > SCENE_HEIGHT));
    }
    //return true if element a overlaps element b
    public boolean elementsOverlap(Rectangle a, Rectangle b) {
        int aX = a.getTopLeft().getX();
        int aMaxX = aX + a.getWidth();

        int aY = a.getTopLeft().getY();
        int aMaxY = aY + a.getHeight();

        int bX = b.getTopLeft().getX();
        int bMaxX = bX + a.getWidth();

        int bY = b.getTopLeft().getY();
        int bMaxY = bY + b.getHeight();

        //check conditions when rectangles dont overlap
        boolean aOverB = (aMaxY < bY);
        boolean aRightOfB = (aX > bMaxX);
        boolean aUnderB = (aY > bMaxY);
        boolean aLeftOfB = (aMaxX < bX);

        return !(aOverB || aRightOfB || aUnderB || aLeftOfB);
    }

}
