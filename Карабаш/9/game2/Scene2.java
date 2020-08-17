package game2;

import game.Character;
import game.Scene;
import game2.error.*;

public class Scene2 extends Scene {

    public GameScriptData gameScriptData = null;
    int lastError = 0;
    int wasOnce = 0;

    public Scene2() {
        fillScene2();
    }

    // made empty to skip filling by parent class
    @Override
    protected void fillScene() {
    }

    protected void fillScene2() {
        lastError = 0;
        if (GameTypeManager.getIsRealGame()) {
            gameScriptData = new GameScriptData();
            int numberOfCharacters = 1 + random.nextInt(SCENE_LENGTH);
            int numberOfFreeCells = SCENE_LENGTH;
            for (int i = 0; i < numberOfCharacters; i++) {
                int positionIndex = random.nextInt(numberOfFreeCells);
                int position = 0;
                while (scene[position] != null || positionIndex > 0) {
                    if (scene[position] == null) {
                        positionIndex--;
                    }
                    position++;
                }
                numberOfFreeCells--;
                Character character = createRandomCharacter(position);
                scene[position] = character;
                gameScriptData.appendStartingCharacterState(character);
            }
        } else {
            try {
                gameScriptData = GameDataIO.loadData(GameTypeManager.getSourceDataFilePath());
            } catch (GameFileReadException | GameClassNotFoundException e) {
                System.out.println(e.getMessage());
                lastError = 1;
                return;
            }
            if (gameScriptData == null) {
                System.out.println("Данные не загружены (null)");
                lastError = 2;
                return;
            }
            for (Character character : gameScriptData.getStartingCharactersState()) {
                scene[character.getPosition()] = character;
            }
        }
    }

    public int getLastError() {
        return lastError;
    }

    public void saveGame() {
        try {
            GameDataIO.saveData(GameTypeManager.getTargetDataFilePath(), gameScriptData);
        } catch (GameFileWriteException e) {
            System.out.println(e.getMessage());
            lastError = 10;
        }
    }

    @Override
    public Integer chooseSpellNumber(Integer allSpellsNumber) {
        Integer chosen;
        if (GameTypeManager.getIsRealGame()) {
            chosen = super.chooseSpellNumber(allSpellsNumber);
            // save if even Null:
            gameScriptData.appendStep(chosen);
        } else {
            chosen = gameScriptData.getNextStep();
        }
        if (chosen != null && (chosen < 0 || chosen >= allSpellsNumber)) {
            chosen = null;
        }
        return chosen;
    }

    public Character getLoadedCharacterByPosition(int position) {
        Character foundCharacter = null;
        for (Character character : gameScriptData.getStartingCharactersState()) {
            if (character.getPosition() == position)
                foundCharacter = character;
        }
        return foundCharacter;
    }

    public Character getOneNextLoadedCharacter() {
        Character character = null;
        Integer characterPosition = gameScriptData.getNextStep();
        if (characterPosition != null) {
            character = getLoadedCharacterByPosition(characterPosition);
        }
        return character;
    }

    @Override
    public Character findOpponentExceptMe(int me) {
        Character character = null;
        if (GameTypeManager.getIsRealGame()) {
            Character[] allExceptMe = super.findAllExceptMe(me);
            if(allExceptMe.length > 0){
                int randomNumber = random.nextInt(allExceptMe.length);
                character = allExceptMe[randomNumber];
            }
            // save if even Null:
            if(character == null){
                gameScriptData.appendStep(null);
            } else {
                gameScriptData.appendStep(character.getPosition());
            }
        } else {
            character = getOneNextLoadedCharacter();
        }
        return character;
    }

    @Override
    public Character findMyNeighbour(int me) {
        Character character;
        if (GameTypeManager.getIsRealGame()) {
            character = super.findMyNeighbour(me);
            // Save if even null:
            if (character != null) {
                gameScriptData.appendStep(character.getPosition());
            } else {
                gameScriptData.appendStep(null);
            }
        } else {
            character = getOneNextLoadedCharacter();
        }
        return character;
    }

    //public Character[] findAllExceptMe(int me) {..} - no need to override - same way to find all
    //public Character[] allEvenCharacters() {..} - no need to override - same way to find all Even
    //public Character[] findAllMagicians() {..}  - no need to override - same way to find all Mag.s
    //public Character[] findAllMonsters() {..} - no need to override - same way to find all Most.s
}
