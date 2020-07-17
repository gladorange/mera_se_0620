package game.spells;

import game.Character;
import game.Magician;
import game.Scene;

public class FireStrike extends Spell {

    public FireStrike() {
        super("Огненное касание", 6);
    }

    @Override
    public void cast(Scene scene, Magician originator) {
        Character opponent = scene.findMyNeighbour(originator.getPosition());
        if (opponent == null) {
            System.out.println(originator.getTypeName() + " " + originator.getName() + " читает заклинание " + this.name + "..");
            System.out.println(" - Нет соседних персонажей.");
            return;
        }
        System.out.println(originator.getTypeName() + " " + originator.getName() + " направляет заклинание " + this.name + " на " + opponent.getName() + "..");
        opponent.takeDamage(this.damage);
        System.out.println(" * " + opponent.getTypeName() + " " + opponent.getName() + " поражен на " +
                this.damage + ". Теперь у него " + opponent.getHealth() + " здоровья");
    }

    public String description() {
        return name + ", здоровье -" + damage + " (одиночное)";
    }

}
