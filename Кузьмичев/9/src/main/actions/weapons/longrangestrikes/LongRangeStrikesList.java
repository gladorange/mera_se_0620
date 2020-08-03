package main.actions.weapons.longrangestrikes;

import main.actions.ActionDescriber;

public enum LongRangeStrikesList implements ActionDescriber {
    BOWSHOT("BowShot","");

    private String name;
    private String description;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    LongRangeStrikesList(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
