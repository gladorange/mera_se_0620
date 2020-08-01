package course.battlegame.gameengine.actions.longrangestrikes;

import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;

public class BowShot extends Weapon {
    public BowShot() {
        super(LongRangeStrikesList.BOWSHOT);
    }

    @Override
    public ArrayList<Transaction> attack(ArrayList<Position>  positions, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        Position archerPosition = new Position();

        for (Position position : positions) {
            if (position.getCharacter() == attacker) {
                archerPosition = position;
                break;
            }
        }

        if (!archerPosition.getTaken()) {
            return transactions;
        }

        for (Position position : positions) {
            if (Math.abs(position.getId() - archerPosition.getId()) >= 3) {
                transactions.add(new ChangeHPTransaction(attacker, position.getCharacter(), -attacker.getPower()));
                transactions.add(new InfoTransaction(String.format("Archer \"%s\" attack \"%s\" on %d hp.",
                        attacker.getName(), position.getCharacter().getName(), attacker.getPower())));
                break;
            }
        }
        return transactions;
    }
}