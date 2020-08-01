package course.battlegame.gameengine.actions.closestrikes;

import course.battlegame.gameengine.actions.WeaponDescriber;

public enum  CloseStrikesList implements WeaponDescriber {
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
