public class TV extends ElectronicItem {
    private Integer volume;

    public TV(String name, Integer price, Integer powerConsumption, Integer volume) {
        super(name, price, powerConsumption);
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getTypeName() {
        return "телевизор";
    }
}
