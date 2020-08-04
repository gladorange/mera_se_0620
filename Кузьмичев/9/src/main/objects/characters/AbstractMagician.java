/*********************************************************
 * File: AbstractMagician.java
 * Purpose: Implements character
 * Notice: (c) 2020 Nikolay Kuzmichev. All rights reserved.
 ********************************************************/

package main.objects.characters;

import annotations.SaveIgnore;

import main.actions.weapons.Weapon;

import main.objects.characters.stuff.Mantle;
import main.objects.characters.stuff.Stuff;

import main.transactions.ChangeHPTransaction;
import main.transactions.ReactionTransaction;
import main.transactions.InfoTransaction;
import main.transactions.WeaponTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractMagician extends AbstractCharacter {
    @SaveIgnore
    protected static Integer MIN_POWER = 10;
    @SaveIgnore
    protected static Integer MAX_POWER = 30;
    @SaveIgnore
    protected static Integer LOW_HEALTH = 20;

    protected AbstractMagician(String name, Integer maxHitPoint, ArrayList<Weapon> weapons) {
        this(name, maxHitPoint, ThreadLocalRandom.current().nextInt(MIN_POWER, MAX_POWER), weapons, null);
    }

    protected AbstractMagician(String name, Integer maxHitPoint, Integer power, ArrayList<Weapon> weapons) {
        this(name, maxHitPoint, power, weapons, null);
    }

    protected AbstractMagician(String name, Integer maxHitPoint, Integer power, ArrayList<Weapon> weapons, Stuff stuff) {
        super(name, maxHitPoint, power, weapons, stuff);
    }

    @Override
    public ArrayList<Transaction> react(WeaponTransaction transaction) {
        ArrayList<Transaction> reaction = new ArrayList<>();

        if (transaction instanceof ChangeHPTransaction) {
            AbstractCharacter attacker = transaction.getActionCreator();
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

            if (getStuff() instanceof Mantle) {
                Integer correctedHitPoints = ((Mantle) getStuff()).protect(hitPoints);
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