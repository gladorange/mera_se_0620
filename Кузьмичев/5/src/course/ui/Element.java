package course.ui;

abstract public class Element {
    private String caption;
    private Point position;
    private Rectangle size;
    private Boolean enable;

    public static String DEFAULT_CAPTION;
    public static Point DEFAULT_POSITION;
    public static Rectangle DEFAULT_SIZE;
    public static Boolean DEFAULT_ENABLE;

    public class ReadyOnlyException extends RuntimeException {
        ReadyOnlyException() {
            System.out.println("Element: Try to operate while not enable.");
        }
    }

    static {
        Element.DEFAULT_CAPTION = "New element";
        Element.DEFAULT_POSITION = new Point(0, 0);
        Element.DEFAULT_SIZE = new Rectangle(10, 10);
        Element.DEFAULT_ENABLE = true;
    }

    public Element() {
        this(DEFAULT_CAPTION, DEFAULT_POSITION, DEFAULT_SIZE, DEFAULT_ENABLE);
    }

    public Element(String caption, Point position, Rectangle size, Boolean enable) {
        this.caption = caption;
        this.position = position;
        this.size = size;
        this.enable = enable;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Rectangle getSize() {
        return this.size;
    }

    public void setSize(Rectangle size) {
        this.size = size;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
