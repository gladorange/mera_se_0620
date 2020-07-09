package course.ui;

public class Rectangle {
    private Integer width;
    private Integer height;

    public class RectangleCreationException extends RuntimeException {
        RectangleCreationException() {
            System.out.println("Rectangle: Negative size.");
        }
    }

    public Rectangle() throws RectangleCreationException {
        this(0, 0);
    }

    public Rectangle(Integer width, Integer height) throws RectangleCreationException {
        if (width < 0 || height < 0) {
            throw new RectangleCreationException();
        }

        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
