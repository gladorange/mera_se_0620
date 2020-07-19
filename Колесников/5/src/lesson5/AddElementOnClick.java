package src.lesson5;

import java.util.Random;

public class AddElementOnClick extends Rectangle implements ButtonClickCallback {

    private UI scene;
    private Random random = new Random();

    public AddElementOnClick(String caption, int elementCoordinateX, int elementCoordinateY, int heigthX, int widthY, UI scene) {
        super(caption, elementCoordinateX, elementCoordinateY, heigthX, widthY);
        this.scene = scene;
    }

    @Override
    public void onButtonClick(){

        int elementCoordinateX = random.nextInt(Parameters.parameters.SCENE_LENGHT_X.getValue());
        int elementCoordinateY = random.nextInt(Parameters.parameters.SCENE_LENGHT_Y.getValue());
        int elementHeightX = random.nextInt(Parameters.parameters.ELEMENT_MAX_HIEGHT_X.getValue());
        int elementWidthY = random.nextInt(Parameters.parameters.ELEMENT_MAX_WIDTH_Y.getValue());

        String changeRectangle = Parameters.rectangles.values()[random.nextInt(Parameters.rectangles.values().length)].name();

        switch (changeRectangle) {
            case  ("BUTTON"):
                scene.addElement(new Button("'Button " + elementCoordinateX + "/" + elementCoordinateY + "'",elementCoordinateX,elementCoordinateY,elementHeightX,elementWidthY));
                break;
            case ("CHECK_BOX"):
                scene.addElement(new CheckBox("'Checkbox " + elementCoordinateX + "/" + elementCoordinateY + "'",elementCoordinateX,elementCoordinateY,elementHeightX,elementWidthY, random.nextBoolean()));
                break;
            case ("TEXT_FIELD"):
                StringBuilder bld = new StringBuilder();
                for (int i = 0; i < random.nextInt(9) + 1; i++){
                    bld.append((char)(random.nextInt(26) + 'a'));
                }
                String text = bld.toString();
                scene.addElement(new TextField("'Textfield " + elementCoordinateX + "/" + elementCoordinateY + "'",elementCoordinateX,elementCoordinateY,elementHeightX,elementWidthY, text));
                break;
            default:
                System.out.println("There is no element to append");
        }
    }
}
