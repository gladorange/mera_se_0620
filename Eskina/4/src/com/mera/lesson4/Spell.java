package com.mera.lesson4;

public abstract class Spell {
    public static final int DEFAULT_POWER = 10;
    protected String spellName;
    protected int power;

    protected Spell(String name) {
        spellName = name;
        power = DEFAULT_POWER;
    }
    public abstract void cast(Magician magician, Scene scene);

    public void printCast(String magicianName, String targetName) {
        System.out.printf("Magician %s is casting %s to %s with power %d\n",magicianName, spellName, targetName, power );
    }

    public void makeDamage(Scene scene, GameCharacter magician, GameCharacter target) {
        printCast(magician.getName(), target.getName());
        target.health -= power;
        scene.checkCharacterAfterAttack(target);
    }

    public boolean isTargetMonster(GameCharacter target) {
        return (target instanceof Monster);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "spellName='" + spellName + '\'' +
                ", power=" + power +
                '}';
    }
}
