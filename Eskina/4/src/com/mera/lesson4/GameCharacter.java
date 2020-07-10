package com.mera.lesson4;

import java.util.Random;

public abstract class GameCharacter {
    public static final Random RAND = new Random();
    protected String name;
    protected int health;
    protected int position;

    protected GameCharacter(int position) {
        this.position = position;
        health = 100;
    }

    public String getName () {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }

    public boolean isTargetAvailableForAttack(GameCharacter target) {
        return ((target != null) && (target != this) && (target.isAlive()));
    }

    public boolean isAlive() {
        return (health > 0);
    }
}
