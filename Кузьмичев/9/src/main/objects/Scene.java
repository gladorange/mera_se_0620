package main.objects;

import main.objects.characters.Character;
import main.transactions.*;

import java.util.*;

public class Scene {
    private static Character NO_CHARACTER = null;

    private String name;
    private Boolean isEndGame = false;

    private Map<Position, Character> battlefield;
    private Integer currentPositionNumber = 0;
    private Integer numberOfMissedMove = 0;

    public Scene(String name) {
        this.name = name;
        battlefield = new HashMap<>();
    }

    public Integer addCharacter(Character newCharacter) {
        for (Position position: battlefield.keySet()) {
            if (battlefield.get(position) == NO_CHARACTER) {
                battlefield.replace(position, newCharacter);
                return position.getPosition();
            }
        }

        Position newPosition = new Position(battlefield.size() + 1);
        battlefield.put(newPosition, newCharacter);
        return newPosition.getPosition();
    }

    public Boolean addCharacter(Character character, Integer newPositionNumber) {
        if (newPositionNumber <= 0) {
            return false;
        }

        Position newPosition = null;

        for (Position position: battlefield.keySet()) {
            if (position.getPosition().equals(newPositionNumber)) {
                newPosition = position;
            }
        }

        if ((newPosition != null) && (battlefield.get(newPosition) == NO_CHARACTER)) {
                battlefield.replace(newPosition, character);
                return true;
        }

        return false;
    }

    public  Boolean getUsedPosition(Integer positionNumber) {
        for(Position position: battlefield.keySet()) {
            if(position.getPosition().equals(positionNumber)) {
                return true;
            }
        }

        return false;
    }

    private Map<Position, Character> getAliveCharacters() {
        Map<Position, Character> aliveCharacters = new HashMap<>();

        for (Position position : battlefield.keySet()) {
            if (battlefield.get(position) != NO_CHARACTER) {
                aliveCharacters.put(position, battlefield.get(position));
            }
        }

        return aliveCharacters;
    }

    public Integer getNumAliveCharacters() {
        return getAliveCharacters().size();
    }

    public Boolean getEndGame() {
        return isEndGame;
    }

    public String getName() {
        return name;
    }

    public void playMove() {
        if (getEndGame()) {
            System.out.printf("Server \"%s\" | Game Over!\n", name);
            return;
        }

        if (battlefield.size() == 0 || getAliveCharacters().keySet().size() == 0) {
            System.out.printf("Server \"%s\" | No players.\n", name);
            return;
        }

        Character currentCharacter = null;

        while (currentCharacter == null) {
            currentPositionNumber = (currentPositionNumber + 1) % battlefield.keySet().size();

            for (Position position: battlefield.keySet()) {
                if (position.getPosition().equals(currentPositionNumber) && (battlefield.get(position) != NO_CHARACTER)) {
                        currentCharacter = battlefield.get(position);
                        break;
                }
            }
        }

        Queue<Transaction> actionsQueue = new ArrayDeque<>(currentCharacter.act(getAliveCharacters()));

        Boolean isExistActionTransaction = false;

        for (Transaction transaction: actionsQueue) {
            if(transaction instanceof WeaponTransaction) {
                isExistActionTransaction = true;
            }
        }

        while (!actionsQueue.isEmpty()) {
            numberOfMissedMove = 0;

            Transaction transaction = actionsQueue.poll();

            if (transaction instanceof WeaponTransaction) {

                Character defender = ((WeaponTransaction) transaction).getActionGetter();

                for (Position position : battlefield.keySet()) {
                    if (battlefield.get(position) == defender) {
                        if (position.getPositionType() != null) {
                            transaction = position.getPositionType().getEffectedTransactions((WeaponTransaction) transaction);
                        }
                        if (position.getEffect() != null) {
                            transaction = position.getEffect().getEffectedTransactions((WeaponTransaction) transaction);
                        }
                        break;
                    }
                }

                ArrayList<Transaction> reaction = defender.react((WeaponTransaction) transaction);
                actionsQueue.addAll(reaction);
                continue;
            }

            if (transaction instanceof InfoTransaction) {
                if (transaction instanceof ReactionTransaction) {
                    if (!((ReactionTransaction) transaction).getExecuted()) {
                        System.out.printf(
                                "Server \"%s\" | Error: %s ( %s ).\n",
                                name, ((ReactionTransaction) transaction).getMessage(), ((ReactionTransaction) transaction).getErrorTransaction());
                        isEndGame = true;
                        return;
                    }
                    continue;
                }

                System.out.printf("Server \"%s\" | %s\n",
                        name, ((InfoTransaction) transaction).getMessage());
            }
        }

        if (!isExistActionTransaction) {
            System.out.printf("Server \"%s\" | Player \"%s\" missed a move.\n", name, currentCharacter.getName());

            numberOfMissedMove++;

            if (numberOfMissedMove.equals(getAliveCharacters().size()) && numberOfMissedMove > 1) {
                isEndGame = true;

                System.out.printf("Server \"%s\" | Standoff!\n", name);

                for (Position position : getAliveCharacters().keySet()) {
                    System.out.printf("Server \"%s\" | Remaining player - \"%s\"\n", name, battlefield.get(position).getName());
                }

                System.out.printf("Server \"%s\" | Game Over!\n", name);
            }
            return;
        }

        for (Position position : battlefield.keySet()) {
            if ((battlefield.get(position) != NO_CHARACTER) && (battlefield.get(position).getHitPoints().equals(0))) {
                System.out.printf("Server \"%s\" | Player \"%s\" was killed.\n", name, battlefield.get(position).getName());
                battlefield.replace(position, NO_CHARACTER);
            }
        }

        Map<Position, Character> aliveCharacters = getAliveCharacters();

        if (aliveCharacters.keySet().size() == 1) {
            isEndGame = true;

            ArrayList<Character> winner = new ArrayList<>(aliveCharacters.values());

            System.out.printf("Server \"%s\" | Player \"%s\" win!\n", name, winner.get(0).getName());
            System.out.printf("Server \"%s\" | Game Over!\n", name);
        }
    }
}