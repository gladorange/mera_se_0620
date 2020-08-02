package course.battlegame.gameengine.objects.positionobjects.characters;

import course.battlegame.annotations.XmlIgnore;
import course.battlegame.annotations.XmlName;
import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.stuff.Stuff;
import course.battlegame.gameengine.transactions.ActionTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Character {
    @XmlIgnore
    public static String DEFAULT_NAME = "NONAME";
    @XmlIgnore
    public static Integer DEFAULT_MIN_HP = 0;
    @XmlIgnore
    public static Integer DEFAULT_MAX_HP = 100;
    @XmlIgnore
    public static Integer DEFAULT_POWER = 1;
    @XmlIgnore
    public static Stuff DEFAULT_STUFF = null;

    @XmlName("ID")
    private Integer id;
    @XmlName("Name")
    private String name;
    @XmlName("FullHealth")
    private Integer maxHitPoint;
    @XmlName("HP")
    private Integer hitPoints;
    @XmlName("Power")
    private Integer power;
    @XmlName("Stuff")
    private Stuff stuff;
    @XmlIgnore
    private static HashSet<Integer> idPool;

    Character(String name, Integer maxHitPoint, Integer power) {
        this(name, maxHitPoint, power, DEFAULT_STUFF);
    }

    Character(String name, Integer maxHitPoint, Integer power, Stuff stuff) {
        if (idPool == null) {
            idPool = new HashSet<>();
        }
        this.id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);

        while (idPool.contains(this.id)) {
            this.id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);
        }

        idPool.add(this.id);

        this.name = name;
        this.hitPoints = maxHitPoint;
        this.maxHitPoint = maxHitPoint;
        this.power = power;
        this.stuff = stuff;

        if (name.isEmpty()) {
            this.name = DEFAULT_NAME;
        }

        if (maxHitPoint <= 0) {
            throw new IllegalStateException("Character max HP less zero");
        }

        if (power <= 0) {
            throw new IllegalStateException("Character power less zero");
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

    public Stuff getStuff() {
        return stuff;
    }

    abstract public ArrayList<Transaction> react(ActionTransaction transaction);
    abstract public ArrayList<Transaction> act(ArrayList<Position> positions);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) &&
                Objects.equals(name, character.name) &&
                Objects.equals(maxHitPoint, character.maxHitPoint) &&
                Objects.equals(hitPoints, character.hitPoints) &&
                Objects.equals(power, character.power) &&
                Objects.equals(stuff, character.stuff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, maxHitPoint, hitPoints, power, stuff);
    }
}