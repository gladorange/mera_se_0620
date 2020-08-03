package main.actions.weapons.closestrikes;

import main.actions.ActionDescriber;

public enum  CloseStrikesList implements ActionDescriber {
    MONSTERSTRIKE("MonsterStrike", "");

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

    CloseStrikesList(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
