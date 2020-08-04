package main.actions.weapons.material;

import main.actions.ActionDescriber;

public enum  MaterialWeaponList implements ActionDescriber {
    BOWSHOT("BowShot",""),
    MONSTERSTRIKE("MonsterStrike", ""),
    KNIGHTSTRIKE("KnightStrike", "");

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

    MaterialWeaponList(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
