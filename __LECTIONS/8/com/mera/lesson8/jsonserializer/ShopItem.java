package com.mera.lesson8.jsonserializer;


public class ShopItem {


    @JsonName("title")
    public String productName;

    @JsonName("count")
    public Integer quantity;

    public String category;

    @JsonIgnore
    public Integer internalId;


    public ShopItem() {
    }

    public ShopItem(String productName, Integer quantity, String category, Integer internalId) {
        this.productName = productName;
        this.quantity = quantity;
        this.category = category;
        this.internalId = internalId;
    }
}
