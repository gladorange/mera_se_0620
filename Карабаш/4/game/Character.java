package game;

import javax.swing.text.AttributeSet;

public class Character {
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
        doAttackSomeone(scene, DEFAULT_DAMAGE);
    }

    protected void doAttackSomeone(Scene scene, int damage) {
        Character someOne = scene.findOpponentExceptMe(position);
        if (someOne == null) {
            System.out.println("Кто-то " + name + " не нашел оппонента для аттаки.");
            return;
        }
        System.out.println("Кто-то " + name + " атакует " + someOne.name + " на " + damage + " единиц урона урона");
        someOne.takeDamage(damage);
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

}
