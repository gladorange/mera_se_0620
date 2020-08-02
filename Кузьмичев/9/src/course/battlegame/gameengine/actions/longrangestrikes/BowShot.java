package course.battlegame.gameengine.actions.longrangestrikes;

import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class BowShot extends LongRangeStrike {
    public BowShot() {
        super(LongRangeStrikesList.BOWSHOT);
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