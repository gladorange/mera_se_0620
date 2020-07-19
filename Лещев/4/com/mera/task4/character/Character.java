package com.mera.task4.character;

import com.mera.task4.main.Scene;

public abstract class Character {

    private int health;
    private final int MAX_HEALTH;
    private final String name;
    private Scene scene;
    private int position;

    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
        MAX_HEALTH = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = (health > MAX_HEALTH) ? MAX_HEALTH : health;
    }

    public String getName() {
        return name;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Perform character's action
     */
    public abstract void act();

    /**
     * Cause damage to this character
     * @param damage caused damage (non-negative value)
     * @param source source of the damage (character or spell)
     * @return effective damage (could depends on character's type)
     */
    public int causeDamage(int damage, Object source) {
        if(damage < 0 || source == null) {
            throw new IllegalArgumentException();
        }
        setHealth(health - damage);
        return damage;
    }

    @Override
    public String toString() {
        return String.format("Персонаж \"%s\" (%d очков здоровья)", name, health);
    }
}
