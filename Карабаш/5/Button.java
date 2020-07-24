public class Button extends Element implements Clickable {
    ButtonClickCallback callback;

    public Button(int x, int y, int width, int height, String caption, ButtonClickCallback callback) {
        super(x, y, width, height, caption);
        this.callback = callback;
    }

    public Button(int x, int y, String caption, ButtonClickCallback callback) {
        super(x, y, caption);
        this.callback = callback;
    }

    @Override
    public void click() {
        callback.onButtonClick();
    }

    @Override
    public String getTypeName() {
        return "Кнопка";
    }

    @Override
    public String toString() {
        String state = isEnabled() ? "включен" : "выключен";
        return getTypeName() +" '"+ getCaption() +"' {" +
                "x=" + getX() +
                ", y=" + getY() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", " + state +
                '}';
    }
}
