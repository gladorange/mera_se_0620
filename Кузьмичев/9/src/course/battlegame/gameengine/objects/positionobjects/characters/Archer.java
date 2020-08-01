package course.battlegame.gameengine.objects.positionobjects.characters;

import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.charactersobjects.CharacterObject;
import course.battlegame.gameengine.objects.positionobjects.characters.charactersobjects.Shield;
import course.battlegame.gameengine.transactions.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Archer extends Character {
    private static Integer MIN_POWER = 10;
    private static Integer MAX_POWER = 15;

    private Weapon weapon = null;

    public Archer(String name, Integer maxHitPoint, Weapon weapon) {
        this(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), null, weapon);
    }

    public Archer(String name, Integer maxHitPoint, Integer power, Weapon weapon) {
        this(name, maxHitPoint, power, null, weapon);
    }

    public Archer(String name, Integer maxHitPoint, Integer power, CharacterObject stuff, Weapon weapon) {
        super(name, maxHitPoint, power, stuff);
        this.weapon = weapon;
    }

    @Override
    public ArrayList<Transaction> act(ArrayList<Position> positions) {
        ArrayList<Position> defenderAndAttackerPosition = new ArrayList<>();

        while (true) {
            Integer randomPositionNumber = ThreadLocalRandom.current().nextInt(positions.size());

            if (positions.get(randomPositionNumber).getCharacter() != this) {
                defenderAndAttackerPosition.add(positions.get(randomPositionNumber));

                for(Position position: positions) {
                    if(position.getCharacter() == this) {
                        defenderAndAttackerPosition.add(position);
                        break;
                    }
                }
                break;
            }
        }
        return weapon.attack(defenderAndAttackerPosition, this);
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

                reply.add(new ReplyTransaction("SUCCESS", transaction, true));

                if (getStuff() instanceof Shield) {
                    Integer correctedHitPoints = ((Shield) getStuff()).protect(hitPoints);
                    setHitPoints(getHitPoints() + correctedHitPoints);

                    reply.add(new InfoTransaction(String.format("Archer \"%s\" protect self by shield.", getName())));
                    reply.add(new InfoTransaction(String.format("Archer \"%s\" got damage on %d hp.", getName(), correctedHitPoints)));
                    continue;
                }

                setHitPoints(getHitPoints() + hitPoints);
                reply.add(new InfoTransaction(String.format("Archer \"%s\" got damage on %d hp.", getName(), hitPoints)));
                continue;
            }

            reply.add(new ReplyTransaction("Bad Transaction.", transaction, false));
        }

        return reply;
    }
}