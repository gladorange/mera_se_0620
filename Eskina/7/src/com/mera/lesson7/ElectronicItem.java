package com.mera.lesson7;

public class ElectronicItem extends ShopItem {
    protected int power;

    public ElectronicItem(String name, int price, int power) {
        super(name, price);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
