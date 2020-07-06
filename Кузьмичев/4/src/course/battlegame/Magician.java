package course.battlegame;

import java.util.Random;

public class Magician extends Character {
    private Spell[] spells;
    private Integer power;
    private static Integer MIN_POWER;
    private static Integer MAX_POWER;

    {
        Magician.MIN_POWER = 5;
        Magician.MAX_POWER = 20;
    }

    public Magician(String name, Integer maxHeatPoint, Spell[] spells) {
        super(name, maxHeatPoint);
        this.spells = spells;
        this.power = new Random().nextInt(Magician.MAX_POWER - Magician.MIN_POWER) + Magician.MIN_POWER;
    }

    public Spell[] getSpells() {
        return this.spells;
    }

    public Integer getHitPower() {
        return this.power;
    }

    private void cast(Spell spell, Position[] positions) {
        System.out.println("Magician " + this.getName() + " cast spell " + spell.toString());
        spell.cast(positions, this);
    }

    void step(Position[] positions) {
        for (Spell sp : spells) {
            if (sp.isBlocked && (new Random().nextBoolean())) {
                continue;
            }

            switch (sp) {
                case HEALLING: {
                    if (this.getHeatPoints() < 20) {
                        cast(sp, positions);
                    }
                    break;
                }
                case LIGHTNING: {
                    Position player = positions[0];
                    for (Position pos : positions) {
                        if (pos.getCharacter().getHeatPoints() > player.getCharacter().getHeatPoints()) {
                            player = pos;
                        }
                    }

                    cast(sp, new Position[]{player});
                    break;
                }
                case CHAINLIGHTNING:
                case FIREWALL:
                case FIRETOUCH:
                case EXILEMONSTERS:
                case MIGRAINE: {
                    cast(sp, positions);
                    break;
                }
            }
            break;
        }
    }

    protected void changeHeatPoints(Character character, Integer heatPoints) {
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
