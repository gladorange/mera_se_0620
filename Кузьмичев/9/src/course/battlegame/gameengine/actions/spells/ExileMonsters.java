package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.sceneobjects.Position;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Character;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Monster;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;

public class ExileMonsters extends Spell {
    public ExileMonsters() {
        super(SpellsList.ELILEMONSTER);
    }

    @Override
    public ArrayList<Transaction> attack(ArrayList<Position>  positions, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (getWeaponBlocked()) {
            transactions.add(new InfoTransaction(String.format("Spell \"%s\" has been casted by the character already.", getDescriber().getName())));
            return transactions;
        }

        for (Position position : positions) {
            if (position.getCharacter() instanceof Monster) {
                transactions.add(new ChangeHPTransaction(attacker, position.getCharacter(), -attacker.getPower()));
                transactions.add(new InfoTransaction(String.format("Magician \"%s\" attack \"%s\" on %d hp.",
                        attacker.getName(), position.getCharacter().getName(), attacker.getPower())));
            }
        }

        setWeaponBlocked(true);
        return transactions;
    }
}