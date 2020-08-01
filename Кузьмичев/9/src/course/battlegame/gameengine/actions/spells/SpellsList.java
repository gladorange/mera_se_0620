package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.actions.WeaponDescriber;

public enum SpellsList implements WeaponDescriber {
    CHAINLIGHTNING("Chainlightning", ""),
    ELILEMONSTER("ExileMonster", ""),
    FIRETOUCH("Firetouch", ""),
    FIREWALL("Firewall", ""),
    HEALLING("Healling", ""),
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
