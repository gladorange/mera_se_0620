package main.actions.weapons.spells;

import main.actions.ActionDescriber;
import main.objects.Position;
import main.objects.characters.Character;
import main.transactions.ChangeHPTransaction;
import main.transactions.InfoTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class Healing extends Spell {
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

        transactions.add(new ChangeHPTransaction(attacker, attacker, attacker.getPower()));
        transactions.add(new InfoTransaction(String.format("Magician \"%s\" is healing self on %d hp.",
                attacker.getName(), attacker.getPower())));

        setBlocked(true);
        return transactions;
    }
}