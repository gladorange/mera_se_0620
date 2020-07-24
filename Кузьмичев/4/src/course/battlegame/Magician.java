package course.battlegame;

import java.util.Random;

public class Magician extends Character {
    private Spell[] spells;
    private Integer power;
    private static Integer MIN_POWER = 5;
    private static Integer MAX_POWER = 20;
    private static Integer LOW_HEALTH = 20;

    public Magician(String name, Integer maxHitPoint, Spell[] spells) {
        super(name, maxHitPoint);
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
        if(spell == null || positions == null){
            return;
        }

        System.out.println("Magician " + this.getName() + " cast spell " + spell.toString());
        spell.cast(positions, this);
    }

    @Override
    void step(Position[] positions) {
        for (Spell sp : spells) {
            if (sp.getSpelled() && (new Random().nextBoolean())) {
                System.out.println(this.getName() + ": spell " + sp.toString() + " was casted bad");
                continue;
            }

            switch (sp) {
                case HEALLING: {
                    if (this.getHitPoints() < Magician.LOW_HEALTH) {
                        cast(sp, positions);
                    }

                    break;
                }
                case LIGHTNING: {
                    Position player = positions[0];
                    for (Position pos : positions) {
                        if (pos.getCharacter().getHitPoints() > player.getCharacter().getHitPoints()) {
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

    @Override
    protected void changeHitPoints(Character character, Integer hitPoints) {
        if(character == null) {
            return;
        }

        this.hitPoints += hitPoints;

        if (this.hitPoints > this.maxHitPoint) {
            this.hitPoints = this.maxHitPoint;
            return;
        }

        if (this.hitPoints < 0) {
            this.hitPoints = 0;
        }
    }
}
