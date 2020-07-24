package game;

import game.spells.MagicBestow;
import game.spells.Spell;
import game.Character;

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
            //System.out.println("Mag"+name+", spel["+i+"]..is "+spellList[i].getClass().getName());
            if (i > 0) {
                boolean isTheSame;
                do {
                    isTheSame = false;
                    //System.out.println("Mag"+name+", spel["+i+"]..was "+spellList[i].getClass().getName());
                    for (int j = 0; j < i - 1; j++) {
                        if (spellList[j].getClass().equals(spellList[i].getClass())) {
                            isTheSame = true;
                            break;
                        }
                    }
                    if (isTheSame) {
                        spellList[i] = MagicBestow.bestowRandomSpell();
                        //System.out.println("..changed by "+spellList[i].getClass().getName());
                    }
                } while (isTheSame);
            }
        }
    }

    public Spell chooseSomeSpell() {
        return spellList[random.nextInt(spellList.length)];
    }

    @Override
    public void doAttackSomeone(Scene scene) {
        Spell spell = chooseSomeSpell();
        spell.cast(scene, this);
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
}
