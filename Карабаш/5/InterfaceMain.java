import static java.lang.String.valueOf;

public class InterfaceMain {

    public static void main(String[] args) {
        UI scene = new UI();
        System.out.println("Добавление основных полей и кнопки...");
        TextField textFieldX = new TextField(5,5, 16, 8, "X", "0");
        TextField textFieldY = new TextField(5,15, 16, 8, "Y", "0");
        Button addElementButton = new Button(5, 25, 50, 10, "Добавить элемент", new AddElementButtonOnClick(scene, textFieldX, textFieldY));
        try {
            scene.addElement(textFieldX);
            scene.addElement(textFieldY);
            scene.addElement(addElementButton);
        } catch (ElementsOverlapException ex){
            System.out.println("Ошибка добавление элемента: " + ex.getMessage());
            return;
        }
        System.out.println("---");
        for (int i = 0; i < 10; i++) {
            System.out.println("Добавление случайного элемента №"+i+"..");
            String randomX = valueOf(Element.random.nextInt(UI.UI_WIDTH));
            String randomY = valueOf(Element.random.nextInt(UI.UI_HEIGHT));
            try {
                textFieldX.setText(randomX);
                textFieldY.setText(randomY);
            } catch (ReadOnlyException readOnlyException) {
                System.out.println("Ошибка установки случайного значения в поле координаты");
            }
            addElementButton.click();
        }
        System.out.println("---");
        System.out.println("Список всех элементов:");
        for (Element element: scene.getElementsList()){
            System.out.println(element);
        }
        System.out.println("---");
        System.out.println("Давайте кликнем:");
        for (Element element : scene.getElementsList()){
            if (element instanceof Clickable){
                if(element.equals(addElementButton)){
                    System.out.println("-пропускаем кнопку "+addElementButton.getCaption());
                } else{
                    ((Clickable) element).click();
                    if(element instanceof CheckBox){
                        String checked = ((CheckBox)element).isChecked ? "выбран" : "не выбран";
                        System.out.println("Кликнут элемент "+element.getCaption()+", новое состояние: "+checked);
                    }
                }
            }
        }
        System.out.println("---");
        System.out.println("Текст в текстовых полях:");
        for (Element element : scene.getElementsList()){
            if (element instanceof TextField){
                       System.out.println("Поле "+element.getCaption()+",текст='"+((TextField)element).getText()+"'");
            }
        }
        System.out.println(".");
    }

}
