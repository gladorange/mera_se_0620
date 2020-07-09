package course.battlegame;

import com.sun.istack.internal.Nullable;

public class Position {
    private Integer positionNumber;
    private Character character;
    private Boolean isTaken;

    public Position() {
        this(0);
    }

    public Position(Integer positionNumber) {
        this.positionNumber = positionNumber;
        this.character = null;
        this.isTaken = false;
    }

    public Integer getPositionNumber() {
        return this.positionNumber;
    }

    void setPositionNumber(Integer positionNumber) {
        this.positionNumber = positionNumber;
    }

    Boolean getTaken() {
        return this.isTaken;
    }

    @Nullable
    Character getCharacter() {
        return this.character;
    }

    void setCharacter(Character character) {
        this.character = character;
        this.isTaken = true;
    }

    void removeCharacter() {
        this.character = null;
        this.isTaken = false;
    }
}
