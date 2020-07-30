package src.lesson5;

public class Rectangle {
    private String caption;
    private int elementCoordinateX;
    private int elementCoordinateY;
    private int heigthX;
    private int widthY;
    private boolean elementEnabled = true;

    public Rectangle(String caption, int elementCoordinateX, int elementCoordinateY, int heigthX, int widthY) {
        this.caption = caption;
        this.elementCoordinateX = elementCoordinateX;
        this.elementCoordinateY = elementCoordinateY;
        this.heigthX = heigthX;
        this.widthY = widthY;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getElementCoordinateX() {
        return elementCoordinateX;
    }

    public void setElementCoordinateX(int elementCoordinateX) {
        this.elementCoordinateX = elementCoordinateX;
    }

    public int getElementCoordinateY() {
        return elementCoordinateY;
    }

    public void setElementCoordinateY(int elementCoordinateY) {
        this.elementCoordinateY = elementCoordinateY;
    }

    public int getHeigthX() {
        return heigthX;
    }

    public void setHeigthX(int heigthX) {
        this.heigthX = heigthX;
    }

    public int getWidthY() {
        return widthY;
    }

    public void setWidthY(int widthY) {
        this.widthY = widthY;
    }

    public boolean isElementEnabled() {
        return elementEnabled;
    }

    public void setElementEnabled(boolean elementEnabled) {
        this.elementEnabled = elementEnabled;
    }

    @Override
    public String toString(){
        return getCaption() + " in coordinates " + getElementCoordinateX() + ", " + getElementCoordinateY() + " with height " + getHeigthX() + " and width " + getWidthY();
    }
}


class TextField extends Rectangle {

    private String text;

    public TextField(String caption, int x, int y, int heigth, int width, String text) {
        super(caption, x, y, heigth, width);
        this.text = text;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}


class Button extends Rectangle implements Clickable {

    private ButtonClickCallback callback = ()->{
        System.out.println("Pressed the button " + getCaption() + " in coordinates " + getElementCoordinateX() + ", " + getElementCoordinateY() + "\n");
    };

    public Button(String caption, int elementCoordinateX, int elementCoordinateY, int heigthX, int widthY) {
        super(caption, elementCoordinateX, elementCoordinateY, heigthX, widthY);
    }

    @Override
    public void click() {
        try{
            if (!isElementEnabled()){
                throw new ReadOnlyException(getCaption());
            }
            callback.onButtonClick();
        }
        catch (ReadOnlyException ex){
            System.out.println(ex.getMessage() + "\n");
        }
    }
}


class CheckBox extends Rectangle implements Clickable {

    private boolean checkBoxEnabled;

    ButtonClickCallback callback = ()->{
        this.checkBoxEnabled = !this.checkBoxEnabled;
        System.out.println("Checkbox " + getCaption() + " is " + this.checkBoxEnabled + "\n");
    };

    public CheckBox(String caption, int elementCoordinateX, int elementCoordinateY, int heigthX, int widthY, boolean checkBoxEnabled) {
        super(caption, elementCoordinateX, elementCoordinateY, heigthX, widthY);
        this.checkBoxEnabled = checkBoxEnabled;
    }

    @Override
    public void click() {
        try{
            if (!isElementEnabled()){
                throw new ReadOnlyException(getCaption());
            }
            callback.onButtonClick();
        }
        catch (ReadOnlyException ex){
            System.out.println(ex.getMessage() + "\n");
        }
    }
}


interface Clickable{
    void click();
}


interface ButtonClickCallback{
    void onButtonClick();
}


