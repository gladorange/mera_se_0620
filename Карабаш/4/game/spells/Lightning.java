package game.spells;

import game.Character;
import game.Magician;
import game.Scene;

public class Lightning extends Spell {

    public Lightning() {
        super("Молния", 5);
    }

    @Override
    public void cast(Scene scene, Magician originator) {
        Character someOne = scene.findOpponentExceptMe(originator.getPosition());
        if (someOne == null) {
            System.out.println(" - " + originator.getTypeName() + " " + originator.getName() + " не нашел оппонента для заклинания " + this.name);
            return;
        }
        System.out.println(originator.getTypeName() + " " + originator.getName() + " направляет заклинание " + this.name + " на " + someOne.getName() + "..");
        someOne.takeDamage(this.damage);
        System.out.println(" * " + someOne.getTypeName() + " " + someOne.getName() + " поражен на " +
                this.damage + ". Теперь у него " + someOne.getHealth() + " здоровья");
    }

    public String description() {
        return name + ", здоровье -" + damage + " (одиночное)";
    }

}
