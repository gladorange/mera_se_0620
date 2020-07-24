public class TV {
    static String model = "Чайка";
    boolean isTurnedOn;
    int volume;

    boolean isTurnedOn() {
        return isTurnedOn;
    }

    void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }



    public static void setModel(String model) {
        TV.model = model;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

}
