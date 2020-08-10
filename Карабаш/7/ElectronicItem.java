public abstract class ElectronicItem extends ShopItem {

    private Integer powerConsumption;

    public ElectronicItem(String name, Integer price, Integer powerConsumption) {
        super(name, price);
        this.powerConsumption = powerConsumption;
    }

    public Integer getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Integer powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
}
