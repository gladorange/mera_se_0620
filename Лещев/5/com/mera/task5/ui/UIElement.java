package com.mera.task5.ui;

import java.util.concurrent.ThreadLocalRandom;

public enum UIElement {
    BUTTON,
    CHECK_BOX,
    TEXT_FIELD;

    public static UIElement getRandomUiElementType() {
        int index = ThreadLocalRandom.current().nextInt(UIElement.values().length);
        return UIElement.values()[index];
    }
}
