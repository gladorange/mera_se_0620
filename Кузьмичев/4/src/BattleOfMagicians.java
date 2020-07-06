import java.util.Random;
import course.battlegame.Scene;
import course.battlegame.Monster;
import course.battlegame.Magician;
import course.battlegame.Spell;

public class BattleOfMagicians {
    public static void main(String[] args) {
        Scene game = new Scene(2);

        System.out.println("Loading scene");
        creationScene(game);

        System.out.println("Start game");
        Integer stepCounter = 0;
        while (++stepCounter <= 100) {
            System.out.println("Step: " + stepCounter);
            game.gameStep();
            if(game.getEndGame()) {
                break;
            }
        }
    }

    private static void creationScene(Scene scene) {
        for (Integer i = 0; i < scene.getMaxPositions(); i++) {
            if (new Random().nextBoolean()) {
                Monster monster = new Monster("monster" + i, 80);
                if (scene.setCharacter(monster) == null){
                    System.out.println("No place for\"" + monster.getName() + "\"");
                    break;
                }
            }
            else {
                Integer numSpells = new Random().nextInt(2) + 1;
                Spell[] spells = new Spell[numSpells];

                for (Integer j = 0; j < spells.length; j++)
                {
                    Spell[] spellList = Spell.values();
                    spells[j] = spellList[new Random().nextInt(Spell.values().length)];
                }

                Magician magician = new Magician("mag" + i, 50, spells);
                if (scene.setCharacter(magician) == null){
                    System.out.println("No place for\"" + magician.getName() + "\"");
                    break;
                }
            }
        }

    }
}
