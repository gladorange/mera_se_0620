package com.mera.task5;

import com.mera.task5.geometry.Point;
import com.mera.task5.geometry.Rectangle;
import com.mera.task5.ui.Element;
import com.mera.task5.ui.ReadOnlyException;
import com.mera.task5.ui.UI;
import com.mera.task5.ui.UIElement;
import com.mera.task5.ui.button.Button;
import com.mera.task5.ui.button.ButtonClickCallback;
import com.mera.task5.ui.checkbox.CheckBox;
import com.mera.task5.ui.text.TextField;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        UI scene = new UI();
        Rectangle buttonGeometry = new Rectangle(new Point(5, 5), 10, 5);
        Rectangle xFieldGeometry = new Rectangle(new Point(5, 11), 5, 5);
        Rectangle yFieldGeometry = new Rectangle(new Point(11, 11), 5, 5);
        TextField xField = new TextField(xFieldGeometry, "x");
        TextField yField = new TextField(yFieldGeometry, "y");
        Button addElementButton = new Button(buttonGeometry, "Добавить элемент"
                                             , new AddElementOnClick(scene, xField, yField));
        try {
            scene.addElement(addElementButton);
            scene.addElement(xField);
            scene.addElement(yField);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //Adding 10 elements at random positions
        for (int i = 0; i < 10; i++) {
            xField.setText(String.valueOf(ThreadLocalRandom.current().nextInt(UI.UI_SCENE_WIDTH + 1)));
            yField.setText(String.valueOf(ThreadLocalRandom.current().nextInt(UI.UI_SCENE_HEIGHT + 1)));
            addElementButton.click();
        }

        //Print results
        System.out.println();
        System.out.println("Состояние сцены после 10ти кликов по кнопке добавления нового элемента:");

        List<Element> sceneElements = scene.getAllElements();
        for (Element element: sceneElements) {
            System.out.println(element.toString());
            try {
                if (element instanceof Button && element != addElementButton) {
                    ((Button) element).click();
                } else if (element instanceof CheckBox) {
                    ((CheckBox) element).click();
                    boolean isChecked = ((CheckBox) element).isChecked();
                    System.out.println("Состояние: " + (isChecked ? "нажата" : "не нажата"));
                } else if (element instanceof TextField) {
                    System.out.println("Текст: \"" + ((TextField) element).getText() + "\"");
                }
            }
            catch (ReadOnlyException exception) {
                System.out.println(exception.getMessage());
                //exception.printStackTrace();
            }
            System.out.println();
        }
    }

    static class AddElementOnClick implements ButtonClickCallback {

        private final UI scene;
        private final TextField xField;
        private final TextField yField;

        AddElementOnClick(UI scene, TextField xField, TextField yField) {
            this.scene = scene;
            this.xField = xField;
            this.yField = yField;
        }

        @Override
        public void onButtonClick() {
            try {
                Element toAdd = generateRandomElement(readPosition());
                if(toAdd != null) {
                    scene.addElement(toAdd);
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        static class PrintPositionOnClick implements ButtonClickCallback {
            private final Button button;

            PrintPositionOnClick(Button button) {
                this.button = button;
            }

            @Override
            public void onButtonClick() {
                System.out.println("Нажата кнопка в " + button.getTopLeft().toString());
            }
        }

        private Point readPosition() {
            int x = Integer.valueOf(xField.getText());
            int y = Integer.valueOf(yField.getText());
            return new Point(x, y);
        }

        private Element generateRandomElement(Point position) {
            Rectangle geometry = generateRandomGeometry(position);
            Element randomElement = null;
            switch (UIElement.getRandomUiElementType()) {
                case BUTTON:
                    Button b = new Button(geometry
                                          , Button.BUTTON_TYPE_NAME + " в " + position.toString());
                    b.setCallback(new PrintPositionOnClick(b));
                    randomElement = b;
                    break;
                case CHECK_BOX:
                    CheckBox cb = new CheckBox(geometry
                                               , CheckBox.CHECK_BOX_TYPE_NAME + " в " + position.toString());
                    cb.setChecked(ThreadLocalRandom.current().nextBoolean());
                    randomElement = cb;
                    break;
                case TEXT_FIELD:
                    TextField tf = new TextField(geometry
                                                 , TextField.TEXT_FIELD_TYPE_NAME + " в " + position.toString());
                    tf.setText(generateRandomString());
                    randomElement = tf;
                    break;
            }
            randomElement.setEnabled(ThreadLocalRandom.current().nextBoolean());
            return randomElement;
        }

        private Rectangle generateRandomGeometry(Point position) {
            int w = ThreadLocalRandom.current().nextInt(1, UI.UI_SCENE_WIDTH / 2);
            int h = ThreadLocalRandom.current().nextInt(1, UI.UI_SCENE_HEIGHT / 2);
            return new Rectangle(position, w, h);
        }

        private String generateRandomString() {
            StringBuilder sb = new StringBuilder();
            int length = ThreadLocalRandom.current().nextInt(1, 11);
            while (length-- > 0) {
                char c = (char) ThreadLocalRandom.current().nextInt(65, 122);
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
