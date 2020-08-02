package course.battlegame.gameengine.objects.positionobjects.characters;

import course.battlegame.annotations.XmlIgnore;
import course.battlegame.annotations.XmlName;
import course.battlegame.gameengine.actions.Weapon;
import course.battlegame.gameengine.actions.WeaponDescriber;
import course.battlegame.gameengine.actions.spells.Spell;
import course.battlegame.gameengine.actions.spells.SpellsList;
import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.stuff.Stuff;
import course.battlegame.gameengine.objects.positionobjects.characters.stuff.Shield;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.ReactionTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.ActionTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Magician extends Character {
    @XmlIgnore
    private static Integer MIN_POWER = 10;
    @XmlIgnore
    private static Integer MAX_POWER = 30;
    @XmlIgnore
    private static Integer LOW_HEALTH = 20;

    @XmlName("Weapons")
    private ArrayList<Weapon> weapons;

    public Magician(String name, Integer maxHitPoint,  ArrayList<Weapon> weapons) {
        this(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), null, weapons);
    }

    public Magician(String name, Integer maxHitPoint, Integer power,  ArrayList<Weapon> weapons) {
        this(name, maxHitPoint, power, null, weapons);
    }

    public Magician(String name, Integer maxHitPoint, Integer power, Stuff stuff, ArrayList<Weapon> weapons) {
        super(name, maxHitPoint, power, stuff);
        this.weapons = weapons;
    }

    public ArrayList<Transaction> act(ArrayList<Position> positions) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Weapon weapon : weapons) {
            WeaponDescriber describer = weapon.getDescriber();
            transactions.add(new InfoTransaction(String.format("Magician \"%s\" is trying use weapon \"%s\".", getName(), describer.getName())));

            if (ThreadLocalRandom.current().nextBoolean()) {
                transactions.add(new InfoTransaction(String.format("Magician \"%s\": \"%s\" used bad.", getName(), describer.getName())));
                break;
            }

            if (weapon.getWeaponBlocked()) {
                transactions.addAll(weapon.attack(positions, this));
                break;
            }

            if (weapon instanceof Spell)
            {
                transactions.add(new InfoTransaction(String.format("Magician \"%s\" is casting spell \"%s\".", getName(), describer.getName())));

                if(describer == SpellsList.HEALLING) {
                    if (getHitPoints() < LOW_HEALTH) {
                        transactions.addAll(weapon.attack(positions, this));
                    }
                }

                transactions.addAll(weapon.attack(positions, this));
                break;
            }

            transactions.add(new ReactionTransaction(String.format("I cannot use this weapon \"%s\"", describer.getName()), null, false));
            break;
        }

        return transactions;
    }

    @Override
    public ArrayList<Transaction> react(ActionTransaction transaction) {
        ArrayList<Transaction> reaction = new ArrayList<>();

        if (transaction instanceof ChangeHPTransaction) {
            Character attacker = transaction.getActionCreator();
            Integer hitPoints = ((ChangeHPTransaction) transaction).getHitPoints();

            if (attacker == null) {
                reaction.add(new ReactionTransaction("Attacker Null Pointer Exception.", transaction, false));
                return reaction;
            }

            reaction.add(new ReactionTransaction("SUCCESS", transaction, true));

            if (hitPoints > 0) {
                setHitPoints(getHitPoints() + hitPoints);
                return reaction;
            }

            if (getStuff() instanceof Shield) {
                Integer correctedHitPoints = ((Shield) getStuff()).protect(hitPoints);
                setHitPoints(getHitPoints() + correctedHitPoints);

                reaction.add(new InfoTransaction(String.format("Magician \"%s\" protects self by shield.", getName())));
                reaction.add(new InfoTransaction(String.format("Magician \"%s\" got damage on %d hp.", getName(), correctedHitPoints)));
                return reaction;
            }

            setHitPoints(getHitPoints() + hitPoints);
            reaction.add(new InfoTransaction(String.format("Magician \"%s\" got damage on %d hp.", getName(), hitPoints)));
            return reaction;
        }

        reaction.add(new ReactionTransaction("Bad Transaction.", transaction, false));
        return reaction;
    }
}