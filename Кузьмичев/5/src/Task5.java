import course.ui.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Task5{
    class NumberFormatException extends RuntimeException {
        NumberFormatException() {
            System.out.println(this.getClass().getSimpleName() + ": Error input data.");
        }
    }

    public static void main(String[] args) {
        UI ui = new UI(new Rectangle(100, 100));
        Button button = new Button(new AddElementOnClick(ui));
        button.setPosition(new Point(5,5));
        button.setCaption("Add element");

        TextField textFieldX = new TextField();
        textFieldX.setCaption("x");

        TextField textFieldY = new TextField();
        textFieldY.setCaption("y");

        for(Integer i = 0; i < 10; i++) {
            textFieldX.setText(((Integer)(new Random().nextInt(100))).toString());
            textFieldY.setText(((Integer)(new Random().nextInt(100))).toString());

            try {
                button.click();
            }
            catch (UI.UIElementPositionException e)
            {
                createLogMessage((new Date().toString()) + ": element was not created.");
            }

        }

        Element[] arrayElements = ui.getAllElements();

        if (arrayElements == null) {
            System.out.println("No elements.");
            return;
        }

        for(Element e: arrayElements) {
            System.out.println(e.getClass().getSimpleName() +
                    " on position <" + e.getPosition().getX() + "," + e.getPosition().getY()
                    + ">, width <" + e.getSize().getWidth() +
                    ">, height <" + e.getSize().getHeight() +
                    ">, caption <" + e.getCaption() + ">.");

            if (e instanceof Button) {
                ((Button) e).click();
                continue;
            }

            if (e instanceof CheckBox) {
                ((CheckBox) e).click();
                System.out.println(((CheckBox) e).getChecked());
                continue;
            }

            if (e instanceof TextField) {
                System.out.println(((TextField) e).getText());
            }
        }
    }

    private static void createLogMessage(String message) {
        try {
            FileWriter logFile = new FileWriter("log.txt", true);
            logFile.append(message + "\r\n");
            logFile.close();
        }
        catch (IOException e) {
            System.out.println("Log: cannot be written.");
        }
    }
}

class AddElementOnClick implements ButtonClickCallback {
    private UI scene;

    AddElementOnClick(UI sceneToAddElements) {
        this.scene = sceneToAddElements;
    }

    private Element generateRandomElement() {
        Element element;

        switch (new Random().nextInt(3)) {
            case 0:
                element = new Button(new PrintTextOnClick());
                break;
            case 1:
                element = new CheckBox(new Random().nextBoolean());
                break;
            default:
                element = new TextField("Java");
        }

        element.setPosition(new Point(new Random().nextInt(5), new Random().nextInt(5)));
        element.setSize(new Rectangle(new Random().nextInt(10), new Random().nextInt(10)));

        return element;
    }

    @Override
    public void onButtonClick(Button sender) {
        Element toAdd = generateRandomElement();
        scene.addElement(toAdd);
    }
}

class PrintTextOnClick implements ButtonClickCallback {
    @Override
    public void onButtonClick(Button sender) {
       System.out.println("Button \"" +sender.getCaption() + "\" clicked on position <" + sender.getPosition().getX() + "," + sender.getPosition().getY() +">.");
    }
}
