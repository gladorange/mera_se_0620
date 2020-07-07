import java.util.Random;

abstract class Creature {
    private String name;
    private int health;

    Creature(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }
    String getName(){
        return this.name;
    }
    void setHealth(int health){
        this.health = health;
    }
    int getHealth(){
        return this.health;
    }

    void healthDamage(int damage){
        this.health -= damage;
    }

    void healthHealing(int damage){
        this.health += damage;
    }



    abstract void attack();
}


class Ktulhu extends Creature implements Monster{
    private Weapon[] weapons = new Weapon[1];

    Ktulhu(String name) {
        super(name);
        setHealth(Parameters.HitPoints.KTULHU.getHealth());
        this.weapons[0] = new MonsterMeleeAttack();
    }

    public void attack(){
        Weapon weapon = selectWeapon(weapons);
        weapon.attackTarget(this);
    }
}


class LightningWizard extends Creature implements Wizard{
    private Weapon[] weapons = new Weapon[3];

    LightningWizard(String name) {
        super(name);
        setHealth(Parameters.HitPoints.LIGHTING_WIZARD.getHealth());
        this.weapons[0] = new MagicLightning();
        this.weapons[1] = new ChainLightning();
        this.weapons[2] = new Healing();
    }

    public void attack(){
        Weapon weapon = selectWeapon(weapons);
        System.out.printf("Wizard %s reads %s spell.%n", this.getName(), weapon.getWeaponClassName());
        weapon.attackTarget(this);
    }
}

class FireWizard extends Creature implements Wizard{
    private Weapon[] weapons = new Weapon[3];

    FireWizard(String name) {
        super(name);
        setHealth(Parameters.HitPoints.FIRE_WIZARD.getHealth());
        this.weapons[0] = new Firewall();
        this.weapons[1] = new BurningTouch();
        this.weapons[2] = new Healing();
    }

    public void attack(){
        Weapon weapon = selectWeapon(weapons);
        System.out.printf("Wizard %s reads %s spell.%n", this.getName(), weapon.getWeaponClassName());
        weapon.attackTarget(this);
    }
}

class Druid extends Creature implements Wizard{
    private Weapon[] weapons = new Weapon[3];

    Druid(String name) {
        super(name);
        setHealth(Parameters.HitPoints.DRUID.getHealth());
        this.weapons[0] = new Migraine();
        this.weapons[1] = new Exorcism();
        this.weapons[2] = new Healing();
    }

    public void attack(){
        Weapon weapon = selectWeapon(weapons);
        System.out.printf("Wizard %s reads %s spell.%n", this.getName(), weapon.getWeaponClassName());
        weapon.attackTarget(this);
    }
}

interface Wizard {

    default Weapon selectWeapon (Weapon[] weapons){
        return weapons[new Random().nextInt(weapons.length)];
    }
}

interface Monster {

    default Weapon selectWeapon (Weapon[] weapons){
        return weapons[new Random().nextInt(weapons.length)];
    }
}


