package course.battlegame.gameengine.objects;

import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.objects.positionobjects.positiontypes.Field;
import course.battlegame.gameengine.transactions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Scene {
    private final String name;
    private final ArrayList<Position> battlefield;
    private Integer currentPositionNumber = 0;
    private Boolean isEndGame = false;

    public Scene(String name) {
        this.name = name;
        battlefield = new ArrayList<>();
    }

    private Position getPosition(Character character) {
        for (Position position : battlefield) {
            if (position.getCharacter() == character) {
                return position;
            }
        }
        return null;
    }

    public void addCharacter(Character character) {
        for (Position position : battlefield) {
            if (!position.getTaken()) {
                position.setCharacter(character);
            }
        }

        battlefield.add(new Position(battlefield.size() + 1, character, new Field()));
    }

    public Boolean addCharacter(Character character, Integer newPositionID) {
        if (newPositionID > 0 && !battlefield.get(newPositionID).getTaken()) {
            battlefield.get(newPositionID - 1).setCharacter(character);
            return true;
        }
        return false;
    }

    private ArrayList<Position> getAliveCharacters() {
        ArrayList<Position> aliveCharacters = new ArrayList<>();

        for (Position position : battlefield) {
            if (position.getTaken()) {
                aliveCharacters.add(position);
            }
        }
        return aliveCharacters;
    }

    public Integer getNumOfAliveCharacters() {
        return getAliveCharacters().size();
    }

    public Boolean getEndGame() {
        return isEndGame;
    }

    public String getName() {
        return name;
    }

    public void gameMove() {
        if (getEndGame()) {
            System.out.printf("Server \"%s\" | Game Over!\n", name);
            return;
        }

        if(battlefield.size() == 0 || getAliveCharacters().size() == 0) {
            System.out.printf("Server \"%s\" | No players.\n", name);
            return;
        }

        Position currentPosition;

        while (true) {
            currentPositionNumber = (currentPositionNumber + 1) % battlefield.size();
            currentPosition = battlefield.get(currentPositionNumber);
            if(currentPosition.getTaken()) {
                break;
            }
        }

        Queue<Transaction> actions = new ArrayDeque<>(currentPosition.getCharacter().act(getAliveCharacters()));

        if(!actions.isEmpty()) {
            while (!actions.isEmpty()) {
                Transaction transaction = actions.poll();

                if (transaction instanceof ActionTransaction) {
                    Character defender = ((ActionTransaction) transaction).getActionGetter();

                   for (Position position : battlefield) {
                        if (position.getCharacter() == defender) {
                            if (position.getPositionType() != null) {
                                transaction = position.getPositionType().getEffectedTransactions((ActionTransaction)transaction);
                            }
                            if (position.getEffect() != null) {
                                transaction = position.getEffect().getEffectedTransactions((ActionTransaction)transaction);
                            }
                            break;
                        }
                    }

                    ArrayList<Transaction> reaction = defender.react((ActionTransaction)transaction);
                    actions.addAll(reaction);
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

                    System.out.printf("Server \"%s\" | Info: %s\n",
                            name, ((InfoTransaction) transaction).getMessage());
                }
            }
        } else {
            System.out.printf("Server \"%s\" | Current player \"%s\" passed move.\n", name, currentPosition.getCharacter().getName());
        }

        for (Position position : battlefield) {
            if (position.getTaken() && position.getCharacter().getHitPoints().equals(0)) {
                System.out.printf("Server \"%s\" | Player \"%s\" was killed.\n", name, position.getCharacter().getName());
                position.removeCharacter();
            }
        }

        if (getAliveCharacters().size() == 1) {
            isEndGame = true;
            System.out.printf("Server \"%s\" | Player \"%s\" win!\n", name, getAliveCharacters().get(0).getCharacter().getName());
            System.out.printf("Server \"%s\" | Game Over!\n", name);
        }
    }
}