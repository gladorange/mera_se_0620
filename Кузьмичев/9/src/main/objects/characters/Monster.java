package main.objects.characters;

import annotations.SaveIgnore;
import main.actions.weapons.closestrikes.MonsterStrike;
import main.objects.Position;
import main.objects.characters.stuff.Stuff;
import main.transactions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {
    @SaveIgnore
    private static Integer MIN_POWER = 10;
    @SaveIgnore
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
    public ArrayList<Transaction> act(Map<Position, Character> battlefield) {
        Position enemyPosition = null;

        while (enemyPosition == null) {
            Integer enemyPositionID = ThreadLocalRandom.current().nextInt(battlefield.keySet().size());

            for (Position position : battlefield.keySet()) {
                if (enemyPositionID.equals(0) && battlefield.get(position) != this) {
                    enemyPosition = position;
                }
                enemyPositionID--;
            }
        }

        Map<Position, Character> enemyAndMe = new HashMap<>();
        enemyAndMe.put(enemyPosition, battlefield.get(enemyPosition));

        for (Position position : battlefield.keySet()) {
            if (battlefield.get(position) == this) {
                enemyAndMe.put(position, this);
                break;
            }
        }

        return (new MonsterStrike().attack(enemyAndMe, this));
    }

    @Override
    public ArrayList<Transaction> react(WeaponTransaction transaction) {
        ArrayList<Transaction> reaction = new ArrayList<>();

        if (transaction instanceof ChangeHPTransaction) {
            Character attacker = transaction.getActionCreator();
            Integer hitPoints = ((ChangeHPTransaction) transaction).getHitPoints();

            if (attacker == null) {
                reaction.add(new ReactionTransaction("Attacker Null Pointer Exception.", transaction, false));
                return reaction;
            }

            setHitPoints(getHitPoints() + hitPoints);
            reaction.add(new ReactionTransaction("SUCCESS", transaction, true));
            reaction.add(new InfoTransaction(String.format("Monster \"%s\" got damage on %d hp.", getName(), hitPoints)));
            return reaction;
        }

        reaction.add(new ReactionTransaction("Bad Transaction.", transaction, false));
        return reaction;
    }
}