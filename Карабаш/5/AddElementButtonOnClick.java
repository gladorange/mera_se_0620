import static java.lang.String.valueOf;

public class AddElementButtonOnClick implements ButtonClickCallback {
    UI scene;
    TextField textFieldX;
    TextField textFieldY;

    AddElementButtonOnClick(UI sceneToAddElements, TextField x, TextField y) {
        scene = sceneToAddElements;
        textFieldX = x;
        textFieldY = y;
    }

    @Override
    public void onButtonClick() {
        Element toAdd = null;
        try {
            toAdd = generateRandomElement();
        } catch (NumberFormatException|ReadOnlyException exception){
            System.out.println("Ошибка создания элемента: " + exception.getMessage());
            return;
        }
        if(toAdd==null){
            return;
        }
        try {
            scene.addElement(toAdd);
        } catch (ElementsOverlapException overlapException) {
            System.out.println("Новый элемент " + toAdd.getTypeName() + " " + toAdd.getCaption() + " не добавлен:" + overlapException.getMessage());
        }
    }

    private Element generateRandomElement() throws NumberFormatException, ReadOnlyException {
        int x = Integer.parseInt(textFieldX.getText());
        int y = Integer.parseInt(textFieldY.getText());
        if (x < 0 || y < 0 || x > UI.UI_WIDTH || y > UI.UI_HEIGHT) {
            throw new NumberFormatException("Координаты вне диапазона x[0," + UI.UI_WIDTH + "], y[0," + UI.UI_HEIGHT + "]");
        }
        String index = valueOf(UI.getNextId());
        switch (Element.random.nextInt(3)) {
            case 0:
                String caption1 = "кнопка:" + index;
                return new Button(x, y, caption1, new RandomButtonOnClick(index));
            case 1:
                String caption2 = "галка:" + index;
                CheckBox checkBox = new CheckBox(x, y, caption2);
                if(!Element.random.nextBoolean()){
                    checkBox.setChecked(false);
                }
                return checkBox;
            case 2:
                String caption3 = "текст:" + index;
                String randomText = TextField.getRandomString(TextField.MAX_LENGTH_RANDOM_TEXT);
                return new TextField(x, y, caption3, randomText);
            default:
                return null;
        }
    }
}
