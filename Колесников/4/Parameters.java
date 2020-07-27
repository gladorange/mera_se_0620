class Parameters {
    enum WeaponDamage {
        MONSTER_MELEE_ATTACK(2),
        MAGIC_LIGHTNING(4),
        CHAIN_LIGHTING(3),
        HEALING(3),
        FIREWALL(4),
        BURNING_TOUCH(5),
        MIGRAINE(3),
        EXORCISM(3);


        private int damage;

        WeaponDamage(int damage) {
            this.damage = damage;
        }

        public int getDamage() {
            return this.damage;
        }
    }

    enum HitPoints {
        KTULHU(11),
        LIGHTING_WIZARD(7),
        FIRE_WIZARD(7),
        DRUID(9);

        private int health;

        HitPoints(int health) {
            this.health = health;
        }

        public int getHealth() {
            return this.health;
        }
    }
}

