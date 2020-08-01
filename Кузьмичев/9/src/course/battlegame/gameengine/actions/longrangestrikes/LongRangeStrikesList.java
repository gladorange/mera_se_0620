package course.battlegame.gameengine.actions.longrangestrikes;

import course.battlegame.gameengine.actions.WeaponDescriber;

public enum LongRangeStrikesList implements WeaponDescriber {
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
