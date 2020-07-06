package course.battlegame;

import java.util.Random;

public class Monster extends Character {
    private Integer power;
    private static Integer MIN_POWER;
    private static Integer MAX_POWER;

    {
      Monster.MIN_POWER = 5;
      Monster.MAX_POWER = 20;
    }

    public Monster(String name, Integer maxHeatPoint) {
        super(name, maxHeatPoint);
        this.power = new Random().nextInt(Monster.MAX_POWER - Monster.MIN_POWER) + Monster.MIN_POWER;
    }

    private void heatCharacter(Character character) {
        System.out.println("Monster \"" + this.getName() + "\" attack \"" + character.getName() + "\" on " + this.power + " hp");
        character.changeHeatPoints(this, -this.power);
    }

    void step(Position[] positions) {
        Integer randomCharacter;

        while (true) {
            randomCharacter = new Random().nextInt(positions.length);
            if (positions[randomCharacter].getCharacter() != this) {
                break;
            }
        }

        heatCharacter(positions[randomCharacter].getCharacter());
    }

    protected void changeHeatPoints(Character character, Integer heatPoints)
    {
        this.heatPoints += heatPoints;

        if (this.heatPoints > this.maxHeatPoint) {
            this.heatPoints = this.maxHeatPoint;
            return;
        }

        if (this.heatPoints < 0) {
            this.heatPoints = 0;
            return;
        }
    }
}
