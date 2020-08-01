package course.battlegame.gameengine.objects.positionobjects.characters;

import course.battlegame.gameengine.actions.closestrikes.MonsterStrike;
import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.charactersobjects.CharacterObject;
import course.battlegame.gameengine.transactions.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {
    private static Integer MIN_POWER = 5;
    private static Integer MAX_POWER = 20;

    public Monster(String name, Integer maxHitPoint) {
        this(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), null);
    }

    public Monster(String name, Integer maxHitPoint, Integer power) {
        this(name, maxHitPoint, power, null);
    }

    public Monster(String name, Integer maxHitPoint, Integer power, CharacterObject stuff) {
        super(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), stuff);
    }

    @Override
    public ArrayList<Transaction> act(ArrayList<Position> positions) {
        ArrayList<Position> defenderAndAttackerPosition = new ArrayList<>();

        while (true) {
            Integer randomEnemyPositionNumber = ThreadLocalRandom.current().nextInt(positions.size());

            if (positions.get(randomEnemyPositionNumber).getCharacter() != this) {
                defenderAndAttackerPosition.add(positions.get(randomEnemyPositionNumber));

                for(Position position: positions) {
                    if(position.getCharacter() == this) {
                        defenderAndAttackerPosition.add(position);
                        break;
                    }
                }
                break;
            }
        }
        return (new MonsterStrike().attack(defenderAndAttackerPosition, this));
    }

    @Override
    public ArrayList<Transaction> react(ArrayList<ActionTransaction> transactions) {
        ArrayList<Transaction> reply = new ArrayList<>();

        for (Transaction transaction: transactions) {
            if(transaction instanceof ChangeHPTransaction) {
                Character attacker = ((ChangeHPTransaction) transaction).getActionCreator();
                Integer hitPoints = ((ChangeHPTransaction) transaction).getHitPoints();

                if(attacker == null) {
                    reply.add(new ReplyTransaction("Attacker Null Pointer Exception.", transaction, false));
                    continue;
                }

                setHitPoints(getHitPoints() + hitPoints);
                reply.add(new ReplyTransaction("SUCCESS", transaction, true));
                reply.add(new InfoTransaction(String.format("Monster \"%s\" got damage on %d hp.", getName(), hitPoints)));
                continue;
            }

            reply.add(new ReplyTransaction("Bad Transaction.", transaction, false));
        }

        return reply;
    }
}