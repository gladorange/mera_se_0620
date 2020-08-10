package game2;

import game.Character;

import java.io.Serializable;
import java.util.ArrayList;

public class GameScriptData implements Serializable {

    private ArrayList<Character> startingCharactersState;
    private ArrayList<Integer> someSteps;
    private Integer lastSeenStepIndex = null;

    public GameScriptData() {
        startingCharactersState = new ArrayList<>();
        someSteps = new ArrayList<>();
    }

    public void appendStartingCharacterState(Character character) {
        startingCharactersState.add(character.clone());
    }

    public void appendStep(Integer stepId) {
        someSteps.add(stepId);
    }

    public ArrayList<Character> getStartingCharactersState() {
        return startingCharactersState;
    }

    public Integer getNextStep() {
        if (lastSeenStepIndex == null) {
            lastSeenStepIndex = -1;
        }
        if (lastSeenStepIndex + 1 < someSteps.size()) {
            lastSeenStepIndex++;
            return someSteps.get(lastSeenStepIndex);
        }
        return null;
    }
}
