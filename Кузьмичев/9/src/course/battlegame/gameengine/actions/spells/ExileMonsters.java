package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.objects.positionobjects.characters.Monster;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class ExileMonsters extends Spell {
    public ExileMonsters() {
        super(SpellsList.ELILEMONSTER);
    }

    @Override
    public ArrayList<Transaction> attack(Map<Position, Character> battlefield, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (getWeaponBlocked()) {
            transactions.add(new InfoTransaction(String.format("Spell \"%s\" has been casted by the character already.", getDescriber().getName())));
            return transactions;
        }

        for (Position position : battlefield.keySet()) {
            Character target = battlefield.get(position);
            if (target instanceof Monster) {
                transactions.add(new ChangeHPTransaction(attacker, target, -attacker.getPower()));
                transactions.add(new InfoTransaction(String.format("Magician \"%s\" is attacking \"%s\" on %d hp.",
                        attacker.getName(), target.getName(), attacker.getPower())));
            }
        }

        setWeaponBlocked(true);
        return transactions;
    }
}