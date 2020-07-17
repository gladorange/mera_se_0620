import java.util.Random;
import course.battlegame.Scene;
import course.battlegame.Monster;
import course.battlegame.Magician;
import course.battlegame.Spell;

public class BattleOfMagicians {
    private static Integer MIN_CHARACTERS = 2;
    private static Integer MAX_CHARACTERS = 10;

    private static Integer MAX_MAGICIAN_HEALTH = 50;
    private static Integer MAX_MONSTERS_HEALTH = 80;

    private static Integer MIN_SPELLS_BOOK = 1;
    private static Integer MAX_SPELLS_BOOK = 3;

    private static Integer MAX_GAME_STEPS = 100;

    public static void main(String[] args) {
        Scene game = new Scene(new Random().nextInt(
                BattleOfMagicians.MAX_CHARACTERS - BattleOfMagicians.MIN_CHARACTERS) + BattleOfMagicians.MIN_CHARACTERS);

        System.out.println("Loading scene");
        creationScene(game);

        System.out.println("Start game");
        Integer stepCounter = 0;
        while (++stepCounter <= BattleOfMagicians.MAX_GAME_STEPS) {
            System.out.println("Step: " + stepCounter);
            game.gameStep();
            if(game.getEndGame()) {
                break;
            }
        }
    }

    private static void creationScene(Scene scene) {
        if (scene == null) {
            return;
        }

        for (Integer i = 0; i < scene.getMaxPositions(); i++) {
            if (new Random().nextBoolean()) {
                Monster monster = new Monster("monster" + i, BattleOfMagicians.MAX_MONSTERS_HEALTH);
                if (scene.addCharacter(monster) == null){
                    System.out.println("No place for \"" + monster.getName() + "\"");
                    break;
                }
            }
            else {
                Integer numSpells = new Random().nextInt(BattleOfMagicians.MAX_SPELLS_BOOK - BattleOfMagicians.MIN_SPELLS_BOOK) + BattleOfMagicians.MIN_SPELLS_BOOK;
                Spell[] spells = new Spell[numSpells];

                for (Integer j = 0; j < spells.length; j++)
                {
                    Spell[] spellList = Spell.values();
                    spells[j] = spellList[new Random().nextInt(Spell.values().length)];
                }

                Magician magician = new Magician("mag" + i, BattleOfMagicians.MAX_MAGICIAN_HEALTH, spells);
                if (scene.addCharacter(magician) == null){
                    System.out.println("No place for \"" + magician.getName() + "\"");
                    break;
                }
            }
        }
    }
}
