package main.actions.weapons.spells;

import main.actions.ActionDescriber;

public enum SpellsList implements ActionDescriber {
    CHAINLIGHTNING("Chainlightning", ""),
    EXILEMONSTER("ExileMonster", ""),
    FIRETOUCH("Firetouch", ""),
    FIREWALL("Firewall", ""),
    HEALING("Healing", ""),
    LIGHTNING("Lightning", ""),
    MIGRAINE("Migraine", "");

    private final String name;
    private final String description;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    SpellsList(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
