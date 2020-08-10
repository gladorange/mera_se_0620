public class Refrigerator extends ElectronicItem {
    private Integer capacity;

    public Refrigerator(String name, Integer price, Integer powerConsumption, Integer capacity) {
        super(name, price, powerConsumption);
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getTypeName() {
        return "холодильник";
    }
}
