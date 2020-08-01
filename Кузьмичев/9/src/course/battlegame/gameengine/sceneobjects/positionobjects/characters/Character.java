package course.battlegame.gameengine.sceneobjects.positionobjects.characters;

import course.battlegame.gameengine.sceneobjects.Position;
import course.battlegame.gameengine.sceneobjects.positionobjects.characters.charactersobjects.CharacterObject;
import course.battlegame.gameengine.transactions.ActionTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Character {
    public static String DEFAULT_NAME = "NONAME";
    public static Integer DEFAULT_MIN_HP = 0;
    public static Integer DEFAULT_MAX_HP = 100;
    public static Integer DEFAULT_POWER = 1;

    private Integer id;
    private String name;
    private Integer maxHitPoint;
    private Integer hitPoints;
    private Integer power;
    private CharacterObject stuff;

    Character(String name, Integer maxHitPoint, Integer power, CharacterObject stuff) {
        this.id = ThreadLocalRandom.current().nextInt();
        this.name = name;
        this.hitPoints = maxHitPoint;
        this.maxHitPoint = maxHitPoint;
        this.power = power;
        this.stuff = stuff;

        if (name.isEmpty()) {
            this.name = DEFAULT_NAME;
        }

        if (maxHitPoint <= 0) {
            this.hitPoints = Character.DEFAULT_MAX_HP;
            this.maxHitPoint = Character.DEFAULT_MAX_HP;

        }
        if (power <= 0) {
            this.power = DEFAULT_POWER;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;

        if (this.hitPoints > this.maxHitPoint) {
            this.hitPoints = this.maxHitPoint;
            return;
        }

        if (this.hitPoints < DEFAULT_MIN_HP) {
            this.hitPoints = DEFAULT_MIN_HP;
        }
    }

    public Integer getMaxHitPoint() {
        return maxHitPoint;
    }

    public Integer getPower() {
        return power;
    }

    public CharacterObject getStuff() {
        return stuff;
    }

    abstract public ArrayList<Transaction> react(ArrayList<ActionTransaction> transactions);
    abstract public ArrayList<Transaction> act(ArrayList<Position> positions);
}