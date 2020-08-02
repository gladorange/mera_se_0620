package course.battlegame.gameengine.objects;

import course.battlegame.annotations.XmlIgnore;
import course.battlegame.annotations.XmlName;
import course.battlegame.gameengine.objects.positionobjects.effects.Effect;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.objects.positionobjects.positiontypes.PositionType;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Position {
    @XmlIgnore
    public static Integer DEFAULT_ID = 0;
    @XmlIgnore
    public static Character DEFAULT_CHARACTER = null;
    @XmlIgnore
    public static PositionType DEFAULT_POSITION_TYPE = null;
    @XmlIgnore
    public static Effect DEFAULT_EFFECT = null;
    @XmlIgnore
    public static Boolean DEFAULT_IS_TAKEN = false;

    @XmlName("ID")
    private Integer id;
    @XmlName("Character")
    private Character character;
    @XmlName("PositionType")
    private PositionType positionType;
    @XmlName("Effect")
    private Effect effect;
    @XmlIgnore
    private Boolean isTaken;

    @XmlIgnore
    private HashSet<Integer> idPool;

    public Position() {
        this(DEFAULT_ID, DEFAULT_CHARACTER, DEFAULT_POSITION_TYPE, DEFAULT_EFFECT);
    }

    public Position(Integer id) {
        this(id, DEFAULT_CHARACTER, DEFAULT_POSITION_TYPE, DEFAULT_EFFECT);
    }

    public Position(Integer id, Character character) {
        this(id, character, DEFAULT_POSITION_TYPE, DEFAULT_EFFECT);
    }

    public Position(Integer id, Character character, PositionType positionType) {
        this(id, character, positionType, DEFAULT_EFFECT);
    }

    public Position(Integer id, Character character, PositionType positionType, Effect effect) {
        if (id > 0) {
            this.id = id;
        } else {
            this.id = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE - 1);
        }

        if(idPool == null) {
            idPool = new HashSet<>();
        }

        while (idPool.contains(this.id)) {
            this.id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);
        }

        idPool.add(this.id);

        this.character = character;

        isTaken = (character != null);

        this.positionType = positionType;
        this.effect = effect;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    void setCharacter(Character character) {
        this.character = character;
        this.isTaken = true;
    }

    void removeCharacter() {
        this.character = DEFAULT_CHARACTER;
        this.isTaken = DEFAULT_IS_TAKEN;
    }
}