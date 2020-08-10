package game;

import game.spells.MagicBestow;
import game.spells.Spell;

import java.util.Random;

public class Magician extends Character {

    final static int MAX_NUM_SPELL = 3;
    final static int MIN_NUM_SPELL = 1;
    Spell[] spellList;
    private Random random = new Random();

    public Magician(String name, int position) {
        super(name, position);
        int numSpells = random.nextInt(MAX_NUM_SPELL - MIN_NUM_SPELL + 1) + MIN_NUM_SPELL;
        spellList = new Spell[numSpells];
        for (int i = 0; i < spellList.length; i++) {
            spellList[i] = MagicBestow.bestowRandomSpell();
            if (i > 0) {
                boolean isTheSame;
                do {
                    isTheSame = false;
                    for (int j = 0; j < i - 1; j++) {
                        if (spellList[j].getClass().equals(spellList[i].getClass())) {
                            isTheSame = true;
                            break;
                        }
                    }
                    if (isTheSame) {
                        spellList[i] = MagicBestow.bestowRandomSpell();
                    }
                } while (isTheSame);
            }
        }
    }

    public Spell chooseSomeSpell(Scene scene) {
        Integer randomSpellNumber = scene.chooseSpellNumber(spellList.length);
        return (randomSpellNumber == null) ? null : spellList[randomSpellNumber];
    }

    @Override
    public void doAttackSomeone(Scene scene) {
        Spell spell = chooseSomeSpell(scene);
        if (spell == null) {
            System.out.println(" - " + this.getTypeName() + " " + this.getName() + ": не выбрано заклинание - пропуск хода.");
        } else {
            spell.cast(scene, this);
        }
    }

    @Override
    public String description() {
        String result = getTypeName() + "    " + getName() + ", здоровье: " + getHealth();
        if (!isAlive()) {
            result += " (мёртв).";
        } else {
            result += " заклинания: ";
            for (int i = 0; i < spellList.length; i++) {
                result += "{" + spellList[i].description() + "}";
            }
        }
        return result;
    }

    @Override
    public String getTypeName() {
        return "Маг";
    }

    @Override
    public Magician clone() {
        Magician newMagician = new Magician(this.name, this.position);
        newMagician.spellList = this.spellList; // just reference because nothing changed inside.
        return newMagician;
    }
}
