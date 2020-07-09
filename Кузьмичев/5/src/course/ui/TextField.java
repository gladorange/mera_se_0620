package course.ui;

public class TextField extends Element {
    private String text;

    public static String DEFAULT_TEXT;

    static {
        TextField.DEFAULT_TEXT = "New TextField";
    }

    public TextField() {
        this(DEFAULT_TEXT);
    }

    public TextField(String text) {
        super();
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
