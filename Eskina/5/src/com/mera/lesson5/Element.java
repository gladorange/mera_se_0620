package com.mera.lesson5;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Element {
    protected Rectangle rect;
    protected ElementType elType;
    protected boolean isTurnedOn;
    protected String caption;
    public static final String EMPTY_STRING = "";

    public Element() {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        rect = new Rectangle(new Point(rand.nextInt(50), rand.nextInt(50)), rand.nextInt(20), rand.nextInt(20));
        isTurnedOn = true;
    }

    public Element(Rectangle rect, ElementType elType) {
        this.rect = rect;
        this.elType = elType;
        isTurnedOn = true;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public ElementType getElType() {
        return elType;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    @Override
    public String toString() {
        return String.format("[%s] в координатах <%d,%d>, ширина <%d>, высота <%d>, Название: <%s>",
                                elType.getName(), rect.getTopLeft().getX(), rect.getTopLeft().getY(),
                                rect.getWidth(), rect.getHeight(), caption);
    }
}
