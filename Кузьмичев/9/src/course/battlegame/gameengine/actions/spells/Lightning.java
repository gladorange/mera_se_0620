package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.sceneobjects.Position;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;

public class Lightning extends Spell {
    public Lightning() {
        super(SpellsList.LIGHTNING);
    }

    @Override
    public ArrayList<Transaction> attack(ArrayList<Position>  positions, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (getWeaponBlocked()) {
            transactions.add(new InfoTransaction(String.format("Spell \"%s\" has been casted by the character already.", getDescriber().getName())));
            return transactions;
        }

        Position healthiestPlayer = positions.get(0);

        for (Position position : positions) {
            if (position.getCharacter().getHitPoints() > healthiestPlayer.getCharacter().getHitPoints() &&
                    position.getCharacter() != attacker) {
                healthiestPlayer = position;
            }
        }

        transactions.add(new ChangeHPTransaction(attacker, healthiestPlayer.getCharacter(), -attacker.getPower()));
        transactions.add(new InfoTransaction(String.format("Magician \"%s\" attack \"%s\" on %d hp.",
                attacker.getName(),healthiestPlayer.getCharacter().getName(), attacker.getPower())));

        setWeaponBlocked(true);
        return transactions;
    }
}