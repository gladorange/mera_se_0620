package game.spells;

import game.Magician;
import game.Scene;
import game.Character;

public class Healing extends Spell {

    public Healing() {
        super("Исцеление", -10);
    }

    @Override
    public void cast(Scene scene, Magician originator) {
        System.out.println(originator.getTypeName() + " " + originator.getName() + " читает заклинание " + this.name + "..");
        originator.takeDamage(this.damage);
        System.out.println(" * " + originator.getTypeName() + " " + originator.getName() + " исцелен на " +
                (-this.damage) + ". Теперь у него " + originator.getHealth() + " здоровья");
    }

    public String description() {
        return this.name + ", здоровье +" + (-this.damage) + " (для себя)";
    }

}
