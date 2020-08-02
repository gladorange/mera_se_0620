package course.battlegame.gameengine.actions;

import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public abstract class Weapon{
    private WeaponDescriber describer;
    private Boolean weaponBlocked = false;

    public Weapon(WeaponDescriber describer) {
        this.describer = describer;
    }

    public Weapon(WeaponDescriber describer, Boolean weaponBlocked) {
        this.describer = describer;
        this.weaponBlocked = weaponBlocked;
    }

    public WeaponDescriber getDescriber() {
        return describer;
    };

    public Boolean getWeaponBlocked() {
        return weaponBlocked;
    }

    protected void setWeaponBlocked(Boolean state) {
        weaponBlocked = state;
    }

    public abstract ArrayList<Transaction> attack(Map<Position, Character>  battlefield, Character attacker);
}