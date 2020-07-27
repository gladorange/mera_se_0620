import java.util.Random;

public class Element {
    private int x, y, width, height;
    private String caption;
    private boolean isEnabled;
    public static Random random = new Random();
    public static final int MIN_WIDTH = 5;
    public static final int MAX_WIDTH = 50;
    public static final int MIN_HEIGHT = 1;
    public static final int MAX_HEIGHT = 30;
    private static final boolean DEFAULT_STATE = true;


    public Element(int x, int y, String caption) {
        this(x,y,
                Element.random.nextInt(Element.MAX_WIDTH - Element.MIN_WIDTH + 1) + Element.MIN_WIDTH,
                Element.random.nextInt(Element.MAX_HEIGHT - Element.MIN_HEIGHT + 1) + Element.MIN_HEIGHT,
                caption);
    }

    public Element(int x, int y, int width, int height, String caption) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.caption = caption;
        isEnabled = DEFAULT_STATE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws ReadOnlyException {
        if (!isEnabled) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws ReadOnlyException {
        if (!isEnabled) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws ReadOnlyException {
        if (!isEnabled) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws ReadOnlyException {
        if (!isEnabled) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        this.height = height;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) throws ReadOnlyException {
        if (!isEnabled) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        this.caption = caption;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getTypeName() {
        return "Element";
    }

    @Override
    public String toString() {
        String state = isEnabled ? "включен" : "выключен";
        return getTypeName() + " '" + caption + "' {" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", " + state +
                '}';
    }
}
