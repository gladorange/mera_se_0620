package com.mera.task4.character;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Character {

    private final int damage;

    public Monster(String name, int health, int damage) {
        super(name, health);
        this.damage = damage;
    }

    @Override
    public void act() {
        Character[] targets = getScene().getAllActiveCharacters();
        //There should be at least 2 characters on the scene at this point
        if(targets.length < 2) {
            return;
        }
        //Try to choose random target if possible
        Character target = null;
        if(targets.length == 2) {
            target = (targets[0].getPosition() != getPosition()) ? targets[0] : targets[1];
        }
        else {
            while(target == null) {
                int randomIndex = ThreadLocalRandom.current().nextInt(targets.length);
                target = targets[randomIndex];
                //Monster can't attack itself
                if(target.getPosition() == getPosition()) {
                    target = null;
                }
            }
        }
        attackCharacter(target);
    }

    @Override
    public String toString() {
        return String.format("Монстр \"%s\" (%d очков здоровья, урон %d)", getName(), getHealth(), damage);
    }

    private void attackCharacter(Character target) {
        System.out.println( String.format("Монстр \"%s\" атакует персонажа \"%s\" на %d единиц(у) урона."
                                          , getName(), target.getName(), target.causeDamage(damage, this)) );
    }
}
