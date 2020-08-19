package com.mera.lesson5;

import java.util.ArrayList;
import java.util.List;

public class UI {
    private List<Rectangle> allElements;
    public static final int MAX_WIDTH_SCENE = 100;
    public static final int MAX_HEIGHT_SCENE = 100;

    public UI() {
        allElements = new ArrayList<>();
    }

    public List<Rectangle> getAllElements() {
        return allElements;
    }

    public void add(Rectangle element) throws ElementsOverlapException {
        verifyElementsOverlap(element);
        allElements.add(element);
    }

    public int getCount() {
        return allElements.size();
    }

    @Override
    public String toString() {
        return "UI{" +
                "allElements=" + allElements +
                '}';
    }

    private void verifyElementsOverlap(Rectangle element) throws ElementsOverlapException {
        int startCoordinateX = element.getX();
        int startCoordinateY = element.getY();
        int endCoordinateX = element.getX() + element.getWidth();
        int endCoordinateY = element.getY() + element.getHeight();
        for (Rectangle e : allElements) {
            int eStartCoordinateX = e.getX();
            int eStartCoordinateY = e.getY();
            int eEndCoordinateX = e.getX() + e.getWidth();
            int eEndCoordinateY = e.getY() + e.getHeight();

            if (((startCoordinateX <= eStartCoordinateX && endCoordinateX >= eStartCoordinateX)
                    || (eStartCoordinateX <= startCoordinateX && eEndCoordinateX >= startCoordinateX))
                    && ((startCoordinateY <= eStartCoordinateY && endCoordinateY >= eStartCoordinateY)
                    || (eStartCoordinateY <= startCoordinateY && eEndCoordinateY >= startCoordinateY))) {
                String message = e + " пересекается с " + element;
                throw new ElementsOverlapException(message);
            }
        }
    }
}
