package main.objects.characters;

import annotations.SaveIgnore;
import annotations.SaveName;
import main.actions.weapons.Weapon;
import main.actions.ActionDescriber;
import main.actions.weapons.spells.Healing;
import main.actions.weapons.spells.Spell;
import main.actions.weapons.spells.SpellsList;
import main.objects.Position;
import main.objects.characters.stuff.Stuff;
import main.objects.characters.stuff.Shield;
import main.transactions.ChangeHPTransaction;
import main.transactions.ReactionTransaction;
import main.transactions.InfoTransaction;
import main.transactions.WeaponTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Magician extends Character {
    @SaveIgnore
    private static Integer MIN_POWER = 10;
    @SaveIgnore
    private static Integer MAX_POWER = 30;
    @SaveIgnore
    private static Integer LOW_HEALTH = 20;

    @SaveName("Weapons")
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

    public ArrayList<Transaction> act(Map<Position, Character> battlefield) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Weapon weapon : weapons) {
            ActionDescriber describer = weapon.getDescriber();
            transactions.add(new InfoTransaction(String.format("Magician \"%s\" is trying use weapon \"%s\".", getName(), describer.getName())));

            if (ThreadLocalRandom.current().nextBoolean()) {
                transactions.add(new InfoTransaction(String.format("Magician \"%s\": \"%s\" used bad.", getName(), describer.getName())));
                break;
            }

            if (weapon.getBlocked()) {
                transactions.addAll(weapon.attack(battlefield, this));
                break;
            }

            if (weapon instanceof Spell)
            {
                transactions.add(new InfoTransaction(String.format("Magician \"%s\" is casting spell \"%s\".", getName(), describer.getName())));

                if(weapon instanceof Healing) {
                    if (getHitPoints() < LOW_HEALTH) {
                        transactions.addAll(weapon.attack(battlefield, this));
                    }
                }

                transactions.addAll(weapon.attack(battlefield, this));
                break;
            }

            transactions.add(new ReactionTransaction(String.format("I cannot use this weapon \"%s\"", describer.getName()), null, false));
            break;
        }

        return transactions;
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