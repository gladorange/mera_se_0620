package game;

import java.io.Serializable;

public class Character implements Serializable, Cloneable {
    protected int health;
    protected String name;
    final static int DEFAULT_HEALTH = 20;
    final static int MAX_HEALTH = 30;
    final static int DEFAULT_DAMAGE = 1;
    protected int position;

    public Character(String name, int position) {
        this.name = name;
        this.health = DEFAULT_HEALTH;
        this.position = position;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health >= 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            System.out.println(" x " + name + " убит");
        } else if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    public void doAttackSomeone(Scene scene) {
        System.out.println("Полу-абстрактный метод - нет атаки.");
    }

    public String getName() {
        return name;
    }

    public String description() {
        return name;
    }

    public String getTypeName() {
        return "Персонаж";
    }

    public int getPosition() {
        return position;
    }

    @Override
    public Character clone(){
        return new Character(this.name, this.position);
    }
}
