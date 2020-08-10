package src.lesson5;

import java.util.ArrayList;

public class UI {
    private Rectangle[][] scene;
    private ArrayList<Rectangle> elementsOnScene = new ArrayList<>();

    public UI(int sceneHeight, int sceneWidth){
        scene = new Rectangle[sceneHeight][sceneWidth];
    }

    public Rectangle[][] getScene() {
        return scene;
    }

    public void setScene(Rectangle[][] scene) {
        this.scene = scene;
    }

    ArrayList<Rectangle> getElementsOnScene() {
        return elementsOnScene;
    }

    void setElementsOnScene(ArrayList<Rectangle> elementsOnScene) {
        this.elementsOnScene = elementsOnScene;
    }

    void addElement(Rectangle element){

        try {
            if ((element.getElementCoordinateX() + element.getHeigthX()) >= scene.length || (element.getElementCoordinateY() + element.getWidthY()) >= scene[element.getElementCoordinateX()].length) {
                throw new OutOfSceneException(element.getCaption());
            }

            for (int x = element.getElementCoordinateX(); x <= (element.getElementCoordinateX() + element.getHeigthX()); x++) {
                for (int y = element.getElementCoordinateY(); y <= (element.getElementCoordinateY() + element.getWidthY()); y++) {
                    if (scene[x][y] != null) {
                        throw new ElementsOverlapException(element.getCaption(), scene[x][y].getCaption());
                    }
                }
            }

            for (int i = element.getElementCoordinateX(); i <= (element.getElementCoordinateX() + element.getHeigthX()); i++) {
                for (int z = element.getElementCoordinateY(); z <= (element.getElementCoordinateY() + element.getWidthY()); z++) {
                    scene[i][z] = element;

                }
            }
            elementsOnScene.add(element);
        }
        catch (OutOfSceneException|ElementsOverlapException ex) {
            System.out.println(ex.getMessage() + "\n");
        }
    }
}



