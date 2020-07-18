package com.mera.lesson5;


public class Checkbox extends Element implements Clickable {
    public static final String CAPTION = "Галка";

    boolean isPressed;

    public Checkbox() {
        super();
        elType = ElementType.CHECK_BOX;
        caption = CAPTION;
    }

    public Checkbox(Rectangle rect, String caption, boolean isPressed) {
        super(rect, ElementType.CHECK_BOX);
        this.caption = (caption.isEmpty() ? (CAPTION + String.format(" <%d, %d>", rect.getTopLeft().getX(), rect.getTopLeft().getY())) : caption);
        this.isPressed = isPressed;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }

    @Override
    public void click() throws ReadOnlyException {
        if (!isTurnedOn) {
            throw new ReadOnlyException("Галка с названием " + caption + " выключена");
        }
        setPressed(!isPressed());
        System.out.printf("Галка в <%d, %d> c названием %s, pressed = <%s>\n", rect.getTopLeft().getX(), rect.getTopLeft().getY(), caption, isPressed);
    }
}
