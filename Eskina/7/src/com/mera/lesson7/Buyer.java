package com.mera.lesson7;

import java.util.Collection;

public interface Buyer {
    void buy(Collection<? extends ShopItem> shop, Object item);
}
