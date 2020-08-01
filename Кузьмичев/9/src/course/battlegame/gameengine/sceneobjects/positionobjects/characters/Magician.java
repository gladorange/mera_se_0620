package course.battlegame.gameengine.sceneobjects.positionobjects.characters;

import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.actions.WeaponDescriber;
import course.battlegame.gameengine.actions.spells.Spell;
import course.battlegame.gameengine.actions.spells.SpellsList;
import course.battlegame.gameengine.sceneobjects.Position;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.charactersobjects.CharacterObject;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.charactersobjects.Shield;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.ReplyTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.ActionTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Magician extends Character {
    private static Integer MIN_POWER = 5;
    private static Integer MAX_POWER = 20;
    private static Integer LOW_HEALTH = 20;

    private ArrayList<Weapon> weapons;

    public Magician(String name, Integer maxHitPoint,  ArrayList<Weapon> weapons) {
        this(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), null, weapons);
    }

    public Magician(String name, Integer maxHitPoint, Integer power,  ArrayList<Weapon> weapons) {
        this(name, maxHitPoint, power, null, weapons);
    }

    public Magician(String name, Integer maxHitPoint, Integer power, CharacterObject stuff,  ArrayList<Weapon> weapons) {
        super(name, maxHitPoint, power, stuff);
        this.weapons = weapons;
    }

    public ArrayList<Transaction> act(ArrayList<Position> positions) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Weapon weapon : weapons) {
            WeaponDescriber describer = weapon.getDescriber();

            if (weapon.getWeaponBlocked() && ThreadLocalRandom.current().nextBoolean()) {
                transactions.add(new InfoTransaction(String.format("%s: weapon \"%s\" was casted bad.", getName(), describer.getName())));
                continue;
            }

            transactions.add(new InfoTransaction(String.format("Magician \"%s\" cast weapon \"%s\".", getName(), describer.getName())));

            if(weapon instanceof Spell)
            {
                if(describer == SpellsList.HEALLING) {
                    if (getHitPoints() < LOW_HEALTH) {
                        transactions.addAll(weapon.attack(positions, this));
                    }
                }

                transactions.addAll(weapon.attack(positions, this));
                break;
            }

            transactions.add(new ReplyTransaction("Unknown weapon", null, false));
            break;
        }

        return transactions;
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

                    reply.add(new InfoTransaction(String.format("Magician \"%s\" protect self by shield.", getName())));
                    reply.add(new InfoTransaction(String.format("Magician \"%s\" got damage on %d hp.", getName(), correctedHitPoints)));
                    continue;
                }

                setHitPoints(getHitPoints() + hitPoints);

                if(hitPoints > 0) {
                    setHitPoints(getHitPoints() + hitPoints);
                    continue;
                }

                reply.add(new InfoTransaction(String.format("Magician \"%s\" got damage on %d hp.", getName(), hitPoints)));
                continue;
            }

            reply.add(new ReplyTransaction("Bad Transaction.", transaction, false));
        }

        return reply;
    }
}