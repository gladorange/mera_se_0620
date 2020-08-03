package main.objects.characters;

import annotations.SaveIgnore;
import annotations.SaveName;
import main.objects.Position;
import main.objects.characters.stuff.Stuff;
import main.transactions.WeaponTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Character {
    @SaveIgnore
    public static Integer DEFAULT_MIN_HP = 0;
    @SaveIgnore
    public static Stuff DEFAULT_STUFF = null;

    @SaveIgnore
    private static HashSet<Integer> idsPool = null;

    @SaveName("ID")
    private Integer id;
    @SaveName("Name")
    private String name;
    @SaveName("FullHealth")
    private Integer maxHitPoint;
    @SaveName("HP")
    private Integer hitPoints;
    @SaveName("Power")
    private Integer power;
    @SaveName("Stuff")
    private Stuff stuff;

    Character(String name, Integer maxHitPoint, Integer power) {
        this(name, maxHitPoint, power, DEFAULT_STUFF);
    }

    Character(String name, Integer maxHitPoint, Integer power, Stuff stuff) {
        if (name == null) {
            throw new IllegalStateException("Character name is null pointer");
        }

        if (name.isEmpty()) {
            throw new IllegalStateException("Character name is empty");
        }

        if (maxHitPoint <= 0) {
            throw new IllegalStateException("Character max HP less or equals zero");
        }

        if (power < 0) {
            throw new IllegalStateException("Character power less zero");
        }

        if (idsPool == null) {
            idsPool = new HashSet<>();
        }

        this.id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);

        while (idsPool.contains(this.id)) {
            this.id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);
        }

        idsPool.add(this.id);

        this.name = name;
        this.hitPoints = maxHitPoint;
        this.maxHitPoint = maxHitPoint;
        this.power = power;
        this.stuff = stuff;

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
        if (hitPoints > maxHitPoint) {
            this.hitPoints = maxHitPoint;
            return;
        }

        if (hitPoints < DEFAULT_MIN_HP) {
            this.hitPoints = DEFAULT_MIN_HP;
            return;
        }

        this.hitPoints = hitPoints;
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

    abstract public ArrayList<Transaction> react(WeaponTransaction transaction);
    abstract public ArrayList<Transaction> act(Map<Position, Character> battlefield);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}