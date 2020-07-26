import org.jetbrains.annotations.NotNull;

import java.util.*;

public class GameMagician extends GameCharacter {

    public GameMagician(String name, int damage) {

        super(name, damage);
    }

    public static void stepOfMagician(GameCharacter[] players, int playerId, Map<String, String> spellBookMagician) {
        spellBookMagician.forEach((magician, spell) -> {
            if(magician.equals(players[playerId].name)) {
                String[] spellArr = spell.split(",");
                int spellId = Integer.parseInt(spellArr[GameCharacter.getRandom(3)]);
                Spell spellForAttack = getSpell(spellId);
                System.out.print("Маг " + players[playerId].name + " читает заклинание " + spellForAttack.spellTitle() + ": ");
                spellForAttack.cast(players, playerId);
            }
        });
    }

    public static Map<String, String> spellBook(GameCharacter[] players) {
        Map<String, String> spellBookMagician = new HashMap<>();
        int countOfSpells = 7;
        for (GameCharacter player : players) {
            if(player instanceof GameMagician) {
                StringBuilder mapValue = new StringBuilder();
                for(int i = 0; i < 3; ) {
                    String spellIndex = Integer.toString(GameCharacter.getRandom(0, countOfSpells));
                    if (mapValue.toString().contains(spellIndex)){
                        continue;
                    }
                    mapValue.append(spellIndex);
                    if(i < 2) {
                        mapValue.append(",");
                    }
                    i++;
                }
                spellBookMagician.put(player.name, mapValue.toString());
            }
        }
        return spellBookMagician;
    }

    private static Spell getSpell(int spellId){
        switch (spellId){
            case 0: return new HealingSpell();
            case 1: return new LightningSpell();
            case 2: return new ChainLightningSpell();
            case 3: return new FireWallSpell();
            case 4: return new FieryTouchSpell();
            case 5: return new ExpellingMonstersSpell();
            case 6: return new MigraineSpell();
            default: return null;
        }
    }

}
