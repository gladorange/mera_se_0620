package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class Lightning extends Spell {
    public Lightning() {
        super(SpellsList.LIGHTNING);
    }

    @Override
    public ArrayList<Transaction> attack(Map<Position, Character> battlefield, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (getWeaponBlocked()) {
            transactions.add(new InfoTransaction(String.format("Spell \"%s\" has been casted by the character already.", getDescriber().getName())));
            return transactions;
        }


        Character target = new ArrayList<>(battlefield.values()).get(0);

        for (Position position : battlefield.keySet()) {
            if (battlefield.get(position).getHitPoints() > target.getHitPoints() && target != attacker) {
                target = battlefield.get(position);
            }
        }

        transactions.add(new ChangeHPTransaction(attacker, target, -attacker.getPower()));
        transactions.add(new InfoTransaction(String.format("Magician \"%s\" is attacking \"%s\" on %d hp.",
                attacker.getName(), target.getName(), attacker.getPower())));

        setWeaponBlocked(true);
        return transactions;
    }
}