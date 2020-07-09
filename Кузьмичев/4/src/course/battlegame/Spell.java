package course.battlegame;

public enum Spell {
    HEALLING{
        @Override
        public void cast(Position[] positions, Magician magician) {
            magician.changeHitPoints(magician, magician.getMaxHitPoint());
            System.out.println("Magician \"" + magician.getName() + "\" healling himself on " + magician.getHitPower() + " hp");
            this.isBlocked = true;
        }
    },
    LIGHTNING{
        @Override
        public void cast(Position[] positions, Magician magician) {
            positions[0].getCharacter().changeHitPoints(magician, -magician.getHitPower());
            Spell.commonMessage(positions[0].getCharacter(), magician);
            this.isBlocked = true;
        }
    },
    CHAINLIGHTNING{
        @Override
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                if (pos.getCharacter() == magician) {
                    continue;
                }
                pos.getCharacter().changeHitPoints(magician, -magician.getHitPower());
                Spell.commonMessage(pos.getCharacter(), magician);
            }

            this.isBlocked = true;
        }
    },
    FIREWALL{
        @Override
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                if (pos.getTaken() & (pos.getPositionNumber() % 2 == 0)) {
                    pos.getCharacter().changeHitPoints(magician, -magician.getHitPower());
                    Spell.commonMessage(pos.getCharacter(), magician);
                }
            }

            this.isBlocked = true;
        }
    },
    FIRETOUCH{
        @Override
        public void cast(Position[] positions, Magician magician) {
            Position magicianPosition = new Position();

            for (Position pos: positions) {
                if (pos.getCharacter() == magician) {
                    magicianPosition = pos;
                }
            }

            for (Position pos: positions) {
                if (Math.abs(pos.getPositionNumber() - magicianPosition.getPositionNumber()) == 1) {
                    pos.getCharacter().changeHitPoints(magician, -magician.getHitPower());
                    Spell.commonMessage(pos.getCharacter(), magician);
                }
            }

            this.isBlocked = true;
        }
    },
    EXILEMONSTERS{
        @Override
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                if (pos.getCharacter() instanceof Monster) {
                    pos.getCharacter().changeHitPoints(magician, -magician.getHitPower());
                    Spell.commonMessage(pos.getCharacter(), magician);
                }
            }

            this.isBlocked = true;
        }
    },
    MIGRAINE{
        @Override
        public void cast(Position[] positions, Magician magician) {
            for (Position pos: positions) {
                pos.getCharacter().changeHitPoints(magician, -magician.getHitPower());
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
