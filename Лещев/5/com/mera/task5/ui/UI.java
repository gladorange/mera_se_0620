package com.mera.task5.ui;

import com.mera.task5.geometry.Point;
import com.mera.task5.geometry.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class UI {
    public static final int UI_SCENE_WIDTH = 100;
    public static final int UI_SCENE_HEIGHT = 100;

    private ArrayList<Element> elements;
    private Rectangle sceneGeometry = new Rectangle(new Point(0, 0), UI_SCENE_WIDTH,  UI_SCENE_HEIGHT);

    public UI() {
        elements = new ArrayList<>();
    }

    public void addElement(Element element) throws Exception {
        if(element == null) {
            return;
        }
        //check if element intersects with the scene rectangle
        if(!Rectangle.hasIntersection(element, sceneGeometry)) {
            throw new IllegalArgumentException("Элемент не может быть добавлен за пределы сцены.");
        }

        if (!elements.isEmpty()) {
            for (Element uiElement : elements) {
                if (Rectangle.hasIntersection(uiElement, element)) {
                    throwOverlapException(element, uiElement);
                }
            }
        }
        elements.add(element);
    }

    public List<Element> getAllElements() {
        return elements;
    }

    private void throwOverlapException(Element toAdd, Element overlapped) throws ElementsOverlapException {
        StringBuilder sb = new StringBuilder("Невозможно добавить элемент ");
        sb.append(toAdd.toString());
        sb.append(" на сцену. Причина: добавляемый элемент пересекается с элементом сцены: ");
        sb.append(overlapped.toString());
        throw new ElementsOverlapException(sb.toString());
    }
}
