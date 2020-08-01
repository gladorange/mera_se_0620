package course.battlegame.gameengine.objects.positionobjects.characters;

import course.battlegame.annotations.XmlIgnore;
import course.battlegame.gameengine.actions.closestrikes.MonsterStrike;
import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.charactersobjects.Stuff;
import course.battlegame.gameengine.transactions.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {
    @XmlIgnore
    private static Integer MIN_POWER = 5;
    @XmlIgnore
    private static Integer MAX_POWER = 20;

    public Monster(String name, Integer maxHitPoint) {
        this(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), null);
    }

    public Monster(String name, Integer maxHitPoint, Integer power) {
        this(name, maxHitPoint, power, null);
    }

    public Monster(String name, Integer maxHitPoint, Integer power, Stuff stuff) {
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
        ArrayList<Transaction> reaction = new ArrayList<>();

        for (Transaction transaction: transactions) {
            if(transaction instanceof ChangeHPTransaction) {
                Character attacker = ((ChangeHPTransaction) transaction).getActionCreator();
                Integer hitPoints = ((ChangeHPTransaction) transaction).getHitPoints();

                if(attacker == null) {
                    reaction.add(new ReactionTransaction("Attacker Null Pointer Exception.", transaction, false));
                    continue;
                }

                setHitPoints(getHitPoints() + hitPoints);
                reaction.add(new ReactionTransaction("SUCCESS", transaction, true));
                reaction.add(new InfoTransaction(String.format("Monster \"%s\" got damage on %d hp.", getName(), hitPoints)));
                continue;
            }

            reaction.add(new ReactionTransaction("Bad Transaction.", transaction, false));
        }

        return reaction;
    }
}