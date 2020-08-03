package main.actions.weapons.closestrikes;

import main.actions.ActionDescriber;
import main.objects.Position;
import main.objects.characters.Character;
import main.transactions.ChangeHPTransaction;
import main.transactions.InfoTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class MonsterStrike extends CloseStrike {
    public ActionDescriber getDescriber() {
        return CloseStrikesList.MONSTERSTRIKE;
    }

    @Override
    public ArrayList<Transaction> attack(Map<Position, Character> battlefield, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Position position : battlefield.keySet()) {
            Character target = battlefield.get(position);

            if (target != attacker) {
                transactions.add(new ChangeHPTransaction(attacker, target, -attacker.getPower()));
                transactions.add(new InfoTransaction(String.format("Monster \"%s\" is attacking \"%s\" on %d hp.",
                        attacker.getName(), target.getName(), attacker.getPower())));
            }
        }

        return transactions;
    }
}