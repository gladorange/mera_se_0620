package com.mera.task5.ui;

import com.mera.task5.geometry.Point;
import com.mera.task5.geometry.Rectangle;

public abstract class Element extends Rectangle {

    private String caption;
    private boolean isEnabled = true;

    protected Element(Rectangle geometry, String caption) {
        super(geometry);
        this.caption = caption;
    }

    protected Element(Rectangle geometry) {
        this(geometry, "");
    }

    protected Element(Point topLeft, int width, int height, String caption) {
        super(topLeft, width, height);
        this.caption = caption;
    }

    protected Element(Point topLeft, int width, int height) {
        this(topLeft, width, height, "");
    }

    protected String buildDescription() {
        StringBuilder sb = new StringBuilder(" в координатах ");
        sb.append(getTopLeft().toString());
        sb.append(", ширина ").append(getWidth());
        sb.append(", высота ").append(getHeight());
        sb.append(", название: \"").append(getCaption()).append('"');
        return sb.toString();
    }

    public String getCaption() {
        return caption;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
