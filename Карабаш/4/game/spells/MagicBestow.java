package game.spells;

import java.util.Random;

public class MagicBestow {

    private static Random random = new Random();

    public static Spell bestowRandomSpell(){
        int numberOfSpells = 7;
        int spellId = random.nextInt(numberOfSpells);
        switch (spellId){
            case 0: return new Healing();
            case 1: return new Lightning();
            case 2: return new ChainLightning();
            case 3: return new WallOfFire();
            case 4: return new FireStrike();
            case 5: return new MostersExpelling();
            case 6: return new Migraine();
            default: return null;
        }
    }
}
