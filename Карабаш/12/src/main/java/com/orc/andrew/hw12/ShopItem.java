package com.orc.andrew.hw12;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ShopItem {
    protected String category;
    protected String name;
    protected double price;
    protected int amount;
    protected String ID;

    public ShopItem(String category, String name, double price, int amount, String ID) {
        this.category = category;
        this.price = price;
        this.name = name;
        this.amount = amount;
        this.ID = ID;
    }

    public static String getRandomItemID() {
        return RandomStringUtils.random(25, true, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ShopItem)) return false;

        ShopItem shopItem = (ShopItem) o;

        return new EqualsBuilder()
                .append(price, shopItem.price)
                .append(amount, shopItem.amount)
                .append(category, shopItem.category)
                .append(name, shopItem.name)
                .append(ID, shopItem.ID)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(category)
                .append(name)
                .append(price)
                .append(amount)
                .append(ID)
                .toHashCode();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "ID='" + ID + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public int compareTo(ShopItem another) {
        int result = this.ID.compareTo(another.ID);
        if (result == 0)
            result = this.category.compareTo(another.category);
        if (result == 0)
            result = this.name.compareTo(another.name);
        if (result == 0)
            result = Double.compare(this.price, another.price);
        if (result == 0)
            result = Integer.compare(this.amount, another.amount);
        return result;
    }

    static public void printFormatted(ShopItem shopItem) {
        final String formatString = "%-10s  %-10s  %-12s  %-10s  %-10s\n";
        //ID  Категория   Наименование    Цена    Остаток
        if (shopItem == null) {
            System.out.format(formatString, "ID", "Категория", "Наименование", "Цена", "Остаток");
            return;
        }
        String priceFormatted = String.format("%10.1f", shopItem.price);
        String amountFormatted = String.format("%10d", shopItem.amount);
        System.out.format(formatString,
                StringUtils.abbreviate(shopItem.ID, 10),
                StringUtils.abbreviate(shopItem.category, 10),
                StringUtils.abbreviate(shopItem.name, 12),
                priceFormatted,
                amountFormatted
        );
    }
}
