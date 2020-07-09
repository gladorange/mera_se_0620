import java.util.Random;

abstract class Weapon {

    private String weaponClassName;
    private int damage;


    String getWeaponClassName() {
        return weaponClassName;
    }
    void setWeaponClassName(String weaponClassName) {
        this.weaponClassName = weaponClassName;
    }
    int getDamage() {
        return damage;
    }
    void setDamage(int damage) {
        this.damage = damage;
    }

    abstract void attackTarget(Creature master);

    void checkCharacterDeath(int targetCharacterNumber){
        if (Scene.getBattleField()[targetCharacterNumber].getHealth()<1){
            System.out.printf("%s died.%n", Scene.getBattleField()[targetCharacterNumber].getName());
            Scene.getBattleField()[targetCharacterNumber] = null;
            Scene.reduceLivingCharacters();
        }
    }


}

class MonsterMeleeAttack extends Weapon{
    MonsterMeleeAttack(){
        setDamage(Parameters.WeaponDamage.MONSTER_MELEE_ATTACK.getDamage() + new Random().nextInt(3));
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] != master && scene[i] != null){
                scene[i].healthDamage(getDamage());
                System.out.printf("Monster %s attacks %s to %d HP.%n", master.getName(), scene[i].getName(), getDamage());
                checkCharacterDeath(i);
                break;
            }
        }
    }
}

class MagicLightning extends Weapon{
    MagicLightning(){
        setDamage(Parameters.WeaponDamage.MAGIC_LIGHTNING.getDamage());
        setWeaponClassName("Lightning");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] != master && scene[i] != null){
                scene[i].healthDamage(getDamage());
                System.out.printf("Lightning hits в %s to %d HP.%n", scene[i].getName(), getDamage());
                checkCharacterDeath(i);
                break;
            }
        }
    }
}

class ChainLightning extends Weapon{
    ChainLightning(){
        setDamage(Parameters.WeaponDamage.CHAIN_LIGHTING.getDamage());
        setWeaponClassName("Chain Lightning");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] != master && scene[i] != null){
                scene[i].healthDamage(getDamage());
                System.out.printf("Chain Lightning hits в %s to %d HP.%n", scene[i].getName(), getDamage());
                checkCharacterDeath(i);
            }
        }
    }
}

class Healing extends Weapon{
    Healing(){
        setDamage(Parameters.WeaponDamage.HEALING.getDamage());
        setWeaponClassName("Healing");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] == master){
                scene[i].healthHealing(getDamage());
                if (scene[i].getHealth() > Parameters.HitPoints.FIRE_WIZARD.getHealth()){
                    scene[i].setHealth(Parameters.HitPoints.FIRE_WIZARD.getHealth());
                }
                System.out.printf("%s heals himself %d HP. His current health is %s.%n", scene[i].getName(), getDamage(), scene[i].getHealth());
                checkCharacterDeath(i);
            }
        }
    }
}

class Firewall extends Weapon{
    Firewall(){
        setDamage(Parameters.WeaponDamage.FIREWALL.getDamage());
        setWeaponClassName("Firewall");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] != master && scene[i] != null && i%2 == 0){
                scene[i].healthDamage(getDamage());
                System.out.printf("Firewall hits в %s to %d HP.%n", scene[i].getName(), getDamage());
                checkCharacterDeath(i);
            }
        }
    }
}

class BurningTouch extends Weapon{
    BurningTouch(){
        setDamage(Parameters.WeaponDamage.BURNING_TOUCH.getDamage());
        setWeaponClassName("Burning Touch");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] == master){
                if (scene[i-1]!= null){
                    scene[i-1].healthDamage(getDamage());
                    System.out.printf("Burning Touch hits в %s to %d HP.%n", scene[i-1].getName(), getDamage());
                    checkCharacterDeath(i-1);
                }
                if(scene[i+1]!= null){
                    scene[i+1].healthDamage(getDamage());
                    System.out.printf("Burning Touch hits в %s to %d HP.%n", scene[i+1].getName(), getDamage());
                    checkCharacterDeath(i+1);
                }
                break;
            }
        }
    }
}

class Migraine extends Weapon{
    Migraine(){
        setDamage(Parameters.WeaponDamage.MIGRAINE.getDamage());
        setWeaponClassName("Migraine");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] != master && scene[i] instanceof Wizard){
                scene[i].healthDamage(getDamage());
                System.out.printf("Migraine hits в %s to %d HP.%n", scene[i].getName(), getDamage());
                checkCharacterDeath(i);
            }
        }
    }
}

class Exorcism extends Weapon{
    Exorcism(){
        setDamage(Parameters.WeaponDamage.EXORCISM.getDamage());
        setWeaponClassName("Exorcism");
    }

    public void attackTarget(Creature master){
        Creature[] scene = Scene.getBattleField();
        for (int i = 0; i < scene.length; i++){
            if (scene[i] != master && scene[i] instanceof Monster){
                scene[i].healthDamage(getDamage());
                System.out.printf("Exorcism hits в %s to %d HP.%n", scene[i].getName(), getDamage());
                checkCharacterDeath(i);
            }
        }
    }
}