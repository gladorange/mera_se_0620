package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class ShopItem {
    public String category;
    public double price;
    public String name;
    public int count;
    public String id;

    public ShopItem(String category, double price, String name, int count, String id) {
        this.category = category;
        this.price = price;
        this.name = name;
        this.count = count;
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ShopItem)) return false;

        ShopItem shopItem = (ShopItem) o;

        EqualsBuilder builder = new EqualsBuilder();
        builder.append(category, shopItem.category);
        builder.append(price, shopItem.price);
        builder.append(name, shopItem.name);
        builder.append(count, shopItem.count);
        builder.append(id, shopItem.id);
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(category);
        builder.append(name);
        builder.append(price);
        builder.append(count);
        builder.append(id);
        return builder.toHashCode();
    }


    public static String getRandomStringId() {
        int length = 25;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    @Override
    public String toString() {
        return "\nShopItem{" +
                "category='" + category + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", id='" + id + '\'' +
                "}";
    }

    static public void printFormatted(ShopItem shopItem) {
        final String formatString = "%-10s  %-10s  %-12s  %-10s  %-10s\n";
        String priceFormatted = String.format("%10.1f", shopItem.price);
        String amountFormatted = String.format("%10d", shopItem.count);
        System.out.format(formatString,
                StringUtils.abbreviate(shopItem.id, 10),
                StringUtils.abbreviate(shopItem.category, 10),
                StringUtils.abbreviate(shopItem.name, 10),
                priceFormatted,
                amountFormatted
        );
    }
}