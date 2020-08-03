package main.actions.weapons.longrangestrikes;

import main.actions.ActionDescriber;
import main.objects.Position;
import main.objects.characters.Character;
import main.transactions.ChangeHPTransaction;
import main.transactions.InfoTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class BowShot extends LongRangeStrike {
    public ActionDescriber getDescriber() {
        return LongRangeStrikesList.BOWSHOT;
    }

    @Override
    public ArrayList<Transaction> attack(Map<Position, Character> battlefield, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        Position archerPosition = null;

        for (Position position : battlefield.keySet()) {

            if (battlefield.get(position) == attacker) {
                archerPosition = position;
                break;
            }
        }

        if (archerPosition == null) {
            return transactions;
        }

        for (Position position : battlefield.keySet()) {
            if (Math.abs(position.getPosition() - archerPosition.getPosition()) <= 10 &&
                    Math.abs(position.getPosition() - archerPosition.getPosition()) > 0) {
                Character target = battlefield.get(position);

                transactions.add(new ChangeHPTransaction(attacker, target, -attacker.getPower()));
                transactions.add(new InfoTransaction(String.format("Archer \"%s\" is attacking \"%s\" on %d hp.",
                        attacker.getName(), target.getName(), attacker.getPower())));
                break;
            }
        }

        return transactions;
    }
}