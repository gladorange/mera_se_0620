import java.util.ArrayList;
import java.util.List;

public class UI {
    private List<Element> elementsList;
    public static final int UI_WIDTH = 100;
    public static final int UI_HEIGHT = 100;
    private static int lastId = 0;

    public UI() {
        elementsList = new ArrayList<>();
    }

    public List<Element> getElementsList() {
        return elementsList;
    }

    public void addElement(Element element) throws ElementsOverlapException {
        checkOverlapping(element);
        elementsList.add(element);
    }

    private void checkOverlapping(Element newElement) throws ElementsOverlapException {
        int newBeginX = newElement.getX();
        int newEndX = newElement.getX() + newElement.getWidth() - 1;
        int newBeginY = newElement.getY();
        int newEndY = newElement.getY() + newElement.getHeight() - 1;
        for (Element element : elementsList) {
            if (isOverlapping(element.getX(), element.getX() + element.getWidth() - 1, newBeginX, newEndX)
                    && isOverlapping(element.getY(), element.getY() + element.getHeight() - 1, newBeginY, newEndY)) {
                String message = newElement.getTypeName() + " " + newElement.getCaption() +
                        "(x,y,w,h)=[" + newBeginX + "," + newBeginY + "," + newElement.getWidth() + "," + newElement.getHeight() +
                        "] пересекается с элементом " +
                        element.getTypeName() + " " + element.getCaption() +
                        "(x,y,w,h)=[" + element.getX() + "," + element.getY() + "," + element.getWidth() + "," + element.getHeight() + ']';
                throw new ElementsOverlapException(message);
            }
        }
    }

    private boolean isOverlapping(int firstBegin, int firstEnd, int secondBegin, int secondEnd) {
        // (x1, x2) (xx1, xx2)
        // x1 <= xx1 & x2 >= xx1  ||
        // xx1 <= x1 & xx2 >= x1
        //System.out.println("x1,x2 vs xx1,xx2  : "+firstBegin+","+firstEnd+" vs "+secondBegin+","+secondEnd);
        //System.out.println(" x1 <= xx1 & x2 >= xx1  :  "+(firstBegin <= secondBegin) + " & " + (firstEnd >= secondBegin) + " || ");
        //System.out.println(" xx1 <= x1 & xx2 >= x1  :  "+(secondBegin <= firstBegin) + " & " + (secondEnd >= firstBegin));
        return (firstBegin <= secondBegin && firstEnd >= secondBegin) || (secondBegin <= firstBegin && secondEnd >= firstBegin);
    }

    public static int getNextId(){
        return lastId++;
    }
}
