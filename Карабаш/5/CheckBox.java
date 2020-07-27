public class CheckBox extends Element implements Clickable {
    boolean isChecked;

    public CheckBox(int x, int y, String caption) {
        super(x, y, caption);
        isChecked = true;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) throws ReadOnlyException {
        if (!isEnabled()) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        isChecked = checked;
    }

    @Override
    public void click() {
        isChecked = !isChecked;
    }

    @Override
    public String getTypeName() {
        return "Галка";
    }

    @Override
    public String toString() {
        String state = isEnabled() ? "включен" : "выключен";
        String checked = isChecked ? "выбран" : "не выбран";
        return getTypeName() +" '"+ getCaption() +"' {" +
                "x=" + getX() +
                ", y=" + getY() +
                ", width=" + getWidth() +
                ", height=" + getHeight() +
                ", " + state +
                ", " + checked +
                '}';
    }
}
