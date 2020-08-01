package course.battlegame.gameengine.actions.closestrikes;

import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;

public class MonsterStrike extends CloseStrike {
    public MonsterStrike() {
        super(CloseStrikesList.MONSTERSTRIKE);
    }

    @Override
    public ArrayList<Transaction> attack(ArrayList<Position> positions, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Position position : positions) {
            if (position.getCharacter() != attacker) {
                transactions.add(new ChangeHPTransaction(attacker, position.getCharacter(), -attacker.getPower()));
                transactions.add(new InfoTransaction(String.format("Monster \"%s\" attack \"%s\" on %d hp.",
                        attacker.getName(), position.getCharacter().getName(), attacker.getPower())));
            }
        }
        return transactions;
    }
}