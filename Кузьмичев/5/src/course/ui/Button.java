package course.ui;

public class Button extends Element implements Clickable {
    private ButtonClickCallback callback;

    public Button(ButtonClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public void click() throws Element.ReadyOnlyException {
        if (!getEnable()) {
            throw new Element.ReadyOnlyException();
        }

        callback.onButtonClick(this);
    }
}
