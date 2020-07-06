package course.battlegame;

import java.util.Random;

public enum Spell {
    HEALLING{
        public void cast(Position[] positions, Magician magician) {
            magician.changeHeatPoints(magician, magician.getMaxHeatPoint());
            System.out.println("Magician \"" + magician.getName() + "\" healling himself on" + magician.getHitPower() + " hp");
            this.isBlocked = true;
        }
    },
    LIGHTNING{
        public void cast(Position[] positions, Magician magician) {
            positions[0].getCharacter().changeHeatPoints(magician, -magician.getHitPower());
            Spell.commonMessage(positions[0].getCharacter(), magician);
            this.isBlocked = true;
        }
    },
    CHAINLIGHTNING{
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                if (pos.getCharacter() == magician) {
                    continue;
                }
                pos.getCharacter().changeHeatPoints(magician, -magician.getHitPower());
                Spell.commonMessage(pos.getCharacter(), magician);
            }

            this.isBlocked = true;
        }
    },
    FIREWALL{
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                if (pos.getTaken() & (pos.getPositionNumber() % 2 == 0)) {
                    pos.getCharacter().changeHeatPoints(magician, -magician.getHitPower());
                    Spell.commonMessage(pos.getCharacter(), magician);
                }
            }

            this.isBlocked = true;
        }
    },
    FIRETOUCH{
        public void cast(Position[] positions, Magician magician) {
            Position magicianPosition = new Position();

            for (Position pos: positions) {
                if (pos.getCharacter() == magician) {
                    magicianPosition = pos;
                }
            }

            for (Position pos: positions) {
                if (Math.abs(pos.getPositionNumber() - magicianPosition.getPositionNumber()) == 1) {
                    pos.getCharacter().changeHeatPoints(magician, -magician.getHitPower());
                    Spell.commonMessage(pos.getCharacter(), magician);
                }
            }

            this.isBlocked = true;
        }
    },
    EXILEMONSTERS{
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                if (pos.getCharacter() instanceof Monster) {
                    pos.getCharacter().changeHeatPoints(magician, -magician.getHitPower());
                    Spell.commonMessage(pos.getCharacter(), magician);
                }
            }

            this.isBlocked = true;
        }
    },
    MIGRAINE{
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                pos.getCharacter().changeHeatPoints(magician, -magician.getHitPower());
                Spell.commonMessage(pos.getCharacter(), magician);
            }
            
            this.isBlocked = true;
        }
    };

    Boolean isBlocked;

    {
        this.isBlocked = false;
    }

    public Boolean getSpelled() {
        return this.isBlocked;
    }
    private static void commonMessage(Character character, Magician magician) {
        System.out.println("Magician \"" + magician.getName() + "\" attack player \""+ character.getName() + "\" on " + magician.getHitPower() + " hp");
    }

    public abstract void cast(Position[] positions, Magician magician);
    
}
