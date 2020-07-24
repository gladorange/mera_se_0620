package com.mera.lesson5;

public class Button extends Element implements Clickable {
    ButtonClickCallback callBack;
    public static final String CAPTION = "Кнопка";

    public Button(ButtonClickCallback callBack) {
        super();
        elType = ElementType.BUTTON;
        caption = "";
        this.callBack = callBack;
    }
    public Button(Rectangle rect, String caption, ButtonClickCallback callback) {
        super(rect, ElementType.BUTTON);
        this.caption = (caption.isEmpty()) ? (CAPTION + String.format(" <%d, %d>", rect.getTopLeft().getX(), rect.getTopLeft().getY())) : caption;
        this.callBack = callback;
    }

    @Override
    public void click() throws ElementsOverlapException, ReadOnlyException {
        if (! isTurnedOn) {
            throw new ReadOnlyException("Кнопка с названием" + caption + " выключена!");
        }
        System.out.printf("Нажата кнопка в <%d, %d> c названием %s\n", rect.getTopLeft().getX(), rect.getTopLeft().getY(), caption);
        callBack.onButtonClick();
    }
}
