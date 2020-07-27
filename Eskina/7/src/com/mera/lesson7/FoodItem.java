package com.mera.lesson7;

public class FoodItem extends ShopItem {
    protected int calories;
    protected int expiryDate;

    public FoodItem(String name, int price, int calories, int expiryDate) {
        super(name, price);
        this.calories = calories;
        this.expiryDate = expiryDate;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }
}
