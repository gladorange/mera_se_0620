package game;

import java.util.Random;

public class Monster extends Character {

    protected int damage;
    final static int MIN_DAMAGE = 1;
    final static int MAX_DAMAGE = 10;

    public Monster(String name, int position) {
        super(name, position);
        Random random = new Random();
        damage = MIN_DAMAGE + random.nextInt(MAX_DAMAGE - MIN_DAMAGE + 1);
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void doAttackSomeone(Scene scene) {
        Character someOne = scene.findOpponentExceptMe(this.position);
        System.out.println(getTypeName() + " " + this.getName() + " атакует " + someOne.getName() + " ..");
        someOne.takeDamage(damage);
        System.out.println(" * " + someOne.getTypeName() + " " + someOne.getName() + " поражен на " +
                this.getDamage() + ". Теперь у него " + someOne.getHealth() + " здоровья");
    }

    @Override
    public String description() {
        if (!isAlive()) {
            return getTypeName() + " " + getName() + ", здоровье: " + getHealth() + " (мёртв).";
        }
        return getTypeName() + " " + getName() + ", здоровье: " + getHealth() + ", сила: " + getDamage();
    }

    @Override
    public String getTypeName() {
        return "Монстр";
    }

    @Override
    public Monster clone(){
        Monster newMonster = new Monster(this.name, this.position);
        newMonster.damage = this.damage;
        return newMonster;
    }
}
