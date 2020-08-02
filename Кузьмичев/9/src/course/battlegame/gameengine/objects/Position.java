package course.battlegame.gameengine.objects;

import course.battlegame.annotations.XmlIgnore;
import course.battlegame.annotations.XmlName;
import course.battlegame.gameengine.objects.positionobjects.effects.Effect;
import course.battlegame.gameengine.objects.positionobjects.positiontypes.PositionType;

import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Position {
    @XmlIgnore
    public static Integer DEFAULT_POSITION = 1;
    @XmlIgnore
    public static PositionType DEFAULT_POSITION_TYPE = null;
    @XmlIgnore
    public static Effect DEFAULT_EFFECT = null;

    @XmlIgnore
    private static HashSet<Integer> idPool;

    @XmlName("ID")
    private Integer id;
    @XmlName("Position")
    private Integer position;
    @XmlName("PositionType")
    private PositionType positionType;
    @XmlName("Effect")
    private Effect effect;


    public Position() {
        this(DEFAULT_POSITION, DEFAULT_POSITION_TYPE, DEFAULT_EFFECT);
    }

    public Position(Integer position) {
        this(position, DEFAULT_POSITION_TYPE, DEFAULT_EFFECT);
    }

    public Position(Integer position, PositionType positionType) {
        this(position, positionType, DEFAULT_EFFECT);
    }

    public Position(Integer position, PositionType positionType, Effect effect) {
        if (position > 0) {
            this.position = position;
        } else {
            this.position = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE - 1);
        }

        if (idPool == null) {
            idPool = new HashSet<>();
        }

        this.id = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE - 1);

        while (idPool.contains(this.id)) {
            this.id = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE - 1);
        }

        idPool.add(this.id);

        this.positionType = positionType;
        this.effect = effect;
    }

    public Integer getPosition() {
        return position;
    }

    void setPosition(Integer position) {
        this.position = position;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public Effect getEffect() {
        return effect;
    }

    void setEffect(Effect effect) {
        this.effect = effect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(id, position.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}