package main.actions.weapons.spells;

import main.actions.ActionDescriber;
import main.objects.Position;
import main.objects.characters.Character;
import main.transactions.ChangeHPTransaction;
import main.transactions.InfoTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class Lightning extends Spell {
    public ActionDescriber getDescriber() {
        return SpellsList.CHAINLIGHTNING;
    }

    @Override
    public ArrayList<Transaction> attack(Map<Position, Character> battlefield, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (getBlocked()) {
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

        setBlocked(true);
        return transactions;
    }
}