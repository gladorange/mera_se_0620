package course.battlegame.gameengine.objects;

import course.battlegame.gameengine.objects.positionobjects.effects.Effect;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.objects.positionobjects.positiontype.PositionType;

import java.util.concurrent.ThreadLocalRandom;

public class Position {
    public static Integer DEFAULT_ID = 0;
    public static Character DEFAULT_CHARACTER = null;
    public static PositionType DEFAULT_POSITION_TYPE = null;
    public static Effect DEFAULT_EFFECT = null;
    public static Boolean DEFAULT_IS_TAKEN = false;

    private Integer id;
    private Character character;
    private PositionType positionType;
    private Effect effect;
    private Boolean isTaken;

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