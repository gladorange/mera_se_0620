public class RandomButtonOnClick implements ButtonClickCallback {
    String buttonIndex;

    public RandomButtonOnClick(String buttonIndex) {
        this.buttonIndex = buttonIndex;
    }

    @Override
    public void onButtonClick() throws NumberFormatException {
            System.out.println("Нажата случайная кнопка с id=" + buttonIndex);
    }
}
