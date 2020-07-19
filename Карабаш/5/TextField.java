public class TextField extends Element {
    String text;
    public static final int MAX_LENGTH_RANDOM_TEXT = 10;

    public TextField(int x, int y, int width, int height, String caption, String text) {
        super(x, y, width, height, caption);
        this.text = text;
    }

    public TextField(int x, int y, String caption, String text) {
        super(x, y, caption);
        this.text = text;
    }

    @Override
    public String getTypeName(){
        return "Текстовое поле";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws ReadOnlyException {
        if (!isEnabled()) {
            throw new ReadOnlyException(ReadOnlyException.DEFAULT_READONLY_MESSAGE);
        }
        this.text = text;
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
                ", текст='" + text +
                "'}";
    }

    public static String getRandomString(int length){
        StringBuilder str = new StringBuilder();
        if(length <= 0){
            return str.toString();
        }
        int codeLetterA = 'A';
        int codeLetterZ = 'Z';
        for (int i = 0; i < length; i++) {
            char c = (char)(Element.random.nextInt(codeLetterZ-codeLetterA+1)+codeLetterA);
            str.append(c);
        }
        return str.toString();
    }
}
