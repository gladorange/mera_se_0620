package com.mera.lesson8;

@XmlTypeName("Блюдо")
public class Meal {
    public static final String EMPTY_STRING = "";

    @XmlIgnore
    String name;

    @XmlIgnore
    int price;

    public Meal() {
        name = EMPTY_STRING;
    }

    public Meal(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
