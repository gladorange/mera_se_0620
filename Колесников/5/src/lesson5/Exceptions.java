package src.lesson5;

class ReadOnlyException extends Exception{
    private final String currentElement;

    ReadOnlyException(String currentElement){
        this.currentElement = currentElement;
    }

    @Override
    public String getMessage() {
        return "The element " + currentElement + " is disabled";
    }
}

class OutOfSceneException extends Exception{
    private final String addedElement;

    OutOfSceneException(String elementCaption){
        this.addedElement = elementCaption;
    }

    @Override
    public String getMessage() {
        return "The element " + addedElement + " is out of scene";
    }
}

class ElementsOverlapException extends Exception{
    private final String addedElement;
    private final String currentElement;

    ElementsOverlapException(String addedElement, String currentElement){
        this.addedElement = addedElement;
        this.currentElement = currentElement;
    }

    @Override
    public String getMessage() {
        return "The element " + addedElement + " intersects with element " + currentElement;
    }
}
