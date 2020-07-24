package course.ui;

public class UI {
    private Element[] elements;
    private Rectangle size;

    private static Rectangle DEFAULT_SIZE;

    {
        UI.DEFAULT_SIZE = new Rectangle(100,100);
    }

    public class UICreationException extends RuntimeException {
        UICreationException() {
            System.out.println("UI: Null pointer size object");
        }
    }

    public class UIElementPositionException extends RuntimeException {
        UIElementPositionException(Element newElement, Element existElement) {
            System.out.println("UI: The new element \"" + newElement.getCaption() +"\" intersects with the existing object \"" + existElement.getCaption() + "\".");
        }
    }

    public class UIErrorElementSizeException extends RuntimeException {
        UIErrorElementSizeException(Element element) {
            System.out.println("UI: The new element \"" + element.getCaption() + "\" is larger than UI size.");
        }
    }

    public UI() {
        this(DEFAULT_SIZE);
    }

    public UI(Rectangle size) throws UICreationException {
        if (size == null) {
            throw new UICreationException();
        }

        this.size = size;
    }

    public Rectangle getSize() {
        return this.size;
    }

    public Element[] getAllElements() {
        return this.elements;
    }

    public void addElement(Element element) throws UIElementPositionException {
        if(element == null) {
            throw new NullPointerException();
        }

        if(element.getSize().getHeight() > this.getSize().getHeight() ||
                element.getSize().getWidth() > this.getSize().getWidth()) {
            throw new UIErrorElementSizeException(element);
        }

        Point elementLU = element.getPosition();

        Point elementLD = new Point(element.getPosition().getX(),element.getPosition().getY() + element.getSize().getHeight());

        Point elementRU = new Point(element.getPosition().getX() + element.getSize().getWidth(), element.getPosition().getY());

        Point elementRD = new Point(element.getPosition().getX() + element.getSize().getWidth(), element.getPosition().getY() + element.getSize().getHeight());

        if (this.elements == null) {
            this.elements = new Element[]{element};
            return;
        }

        for (Element e : elements) {
            Point eLU = e.getPosition();

            Point eLD = new Point(e.getPosition().getX(),e.getPosition().getY() + e.getSize().getHeight());

            Point eRU = new Point(e.getPosition().getX() + e.getSize().getWidth(), e.getPosition().getY());

            Point eRD = new Point(e.getPosition().getX() + e.getSize().getWidth(), e.getPosition().getY() + e.getSize().getHeight());

            // if the new object intersects with the existing object
            if ((elementLU.getX() > eLU.getX() && elementLU.getX() < eRD.getX() &&
                    elementLU.getY() > eLU.getY() && elementLU.getY() < eRD.getY()) ||

                    (elementLD.getX() > eLU.getX() && elementLD.getX() < eRD.getX() &&
                            elementLD.getY() > eLU.getY() && elementLD.getY() < eRD.getY()) ||

                    (elementRU.getX() > eLU.getX() && elementRU.getX() < eRD.getX() &&
                            elementRU.getY() > eLU.getY() && elementRU.getY() < eRD.getY()) ||

                    (elementRD.getX() > eLU.getX() && elementRD.getX() < eRD.getX() &&
                            elementRD.getY() > eLU.getY() && elementRD.getY() < eRD.getY()) ||

                    // if the new object is larger and absorbs the existing object

                    (eLU.getX() > elementLU.getX() && eLU.getX() < elementRD.getX() &&
                            eLU.getY() > elementLU.getY() && eLU.getY() < elementRD.getY()) ||

                    (eLD.getX() > elementLU.getX() && eLD.getX() < elementRD.getX() &&
                            eLD.getY() > elementLU.getY() && eLD.getY() < elementRD.getY()) ||

                    (eRU.getX() > elementLU.getX() && eRU.getX() < elementRD.getX() &&
                            eRU.getY() > elementLU.getY() && eRU.getY() < elementRD.getY()) ||

                     (eRD.getX() > elementLU.getX() && eRD.getX() < elementRD.getX() &&
                            eRD.getY() > elementLU.getY() && eRD.getY() < elementRD.getY())) {
                throw new UIElementPositionException(element, e);
            }
        }

        Element[] elements = new Element[this.elements.length + 1];

        for (Integer i = 0; i < this.elements.length; i++) {
            elements[i] = this.elements[i];
        }

        elements[elements.length - 1] = element;

        this.elements = elements;
    }
}
