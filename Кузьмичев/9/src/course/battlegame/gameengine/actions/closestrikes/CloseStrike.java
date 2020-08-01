package course.battlegame.gameengine.actions.closestrikes;

import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.actions.WeaponDescriber;

public abstract class CloseStrike extends Weapon{
    public CloseStrike(WeaponDescriber describer) {
        super(describer);
    }
}
