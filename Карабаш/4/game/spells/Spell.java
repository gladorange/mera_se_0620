package game.spells;

import game.Magician;
import game.Scene;
import game.Character;

abstract public class Spell {
    protected String name;
    protected int damage;

    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public abstract void cast(Scene scene, Magician originator);

    public abstract String description();
}
