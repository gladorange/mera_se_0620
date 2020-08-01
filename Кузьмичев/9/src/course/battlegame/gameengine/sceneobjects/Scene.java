package course.battlegame.gameengine.sceneobjects;

import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Character;
import course.battlegame.gameengine.sceneobjects.positionobjects.positiontype.Field;
import course.battlegame.gameengine.transactions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Scene {
    private final String name;
    private final ArrayList<Position> battlefield;
    private Integer currentPositionNumber = 0;
    private Boolean isEndGame = false;

    public Scene(String name, Integer startNumOfPositions) {
        this.name = name;

        if (startNumOfPositions <= 0) {
            throw new IllegalStateException("Wrong Number Of Positions.");
        }

        battlefield = new ArrayList<>();

        while (startNumOfPositions-- > 0) {
            battlefield.add(new Position(battlefield.size() + 1, null, new Field()));
        }
    }

    private Position getPosition(Character character) {
        for (Position position : battlefield) {
            if (position.getCharacter() == character) {
                return position;
            }
        }
        return null;
    }

    public Character addCharacter(Character character) {
        for (Position position : battlefield) {
            if (!position.getTaken()) {
                position.setCharacter(character);
                return character;
            }
        }

        battlefield.add(new Position(battlefield.size() + 1, character, new Field()));

        return character;
    }

    public Character addCharacter(Character character, Integer newPositionID) {

        if (newPositionID > 0 && !battlefield.get(newPositionID).getTaken()) {
            battlefield.get(newPositionID).setCharacter(character);
            return character;
        }
        return null;
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
            System.out.println("Game Over!");
            return;
        }

        if (getAliveCharacters().size() == 0) {
            System.out.println("No players.");
            return;
        }

        currentPositionNumber = (currentPositionNumber + 1) % battlefield.size();
        Position currentPosition = battlefield.get(currentPositionNumber);

        while (!currentPosition.getTaken()) {
            currentPositionNumber = (currentPositionNumber + 1) % battlefield.size();
            currentPosition = battlefield.get(currentPositionNumber);
        }

        Queue<Transaction> actions = new ArrayDeque<>(currentPosition.getCharacter().act(getAliveCharacters()));

        if(!actions.isEmpty()) {
            while (!actions.isEmpty()) {
                Transaction transaction = actions.poll();

                if (transaction instanceof ActionTransaction) {
                    Character defender = ((ActionTransaction) transaction).getActionGetter();

                    ArrayList<ActionTransaction> transactionForDefender = new ArrayList<>();
                    transactionForDefender.add((ActionTransaction) transaction);

                   for (Position position : battlefield) {
                        if (position.getCharacter() == defender) {
                            if (position.getPositionType() != null) {
                                transactionForDefender = position.getPositionType().getEffectedTransactions(transactionForDefender);
                            }

                            if (position.getEffect() != null) {
                                transactionForDefender = position.getEffect().getEffectedTransactions(transactionForDefender);
                            }
                            break;
                        }
                    }

                    ArrayList<Transaction> reply = defender.react(transactionForDefender);
                    actions.addAll(reply);
                    continue;
                }

                if (transaction instanceof InfoTransaction) {
                    if (transaction instanceof ReplyTransaction) {
                        if (!((ReplyTransaction) transaction).getExecuted()) {
                            System.out.println(String.format(
                                    "Server \"%s\" | Error: %s ( %s ).",
                                    name, ((ReplyTransaction) transaction).getMessage(), ((ReplyTransaction) transaction).getErrorTransaction()));
                            isEndGame = true;
                            return;
                        }
                        continue;
                    }

                    System.out.println(String.format("Server \"%s\" | Info: %s.",
                            name, ((InfoTransaction) transaction).getMessage()));
                }
            }
        } else {
            System.out.println(String.format("Current player \"%s\" passed move.", currentPosition.getCharacter().getName()));
        }

        for (Position position : battlefield) {
            if (position.getTaken() && position.getCharacter().getHitPoints().equals(0)) {
                System.out.println(String.format("Player \"%s\" was killed.", position.getCharacter().getName()));
                position.removeCharacter();
            }
        }

        if (getAliveCharacters().size() == 1) {
            isEndGame = true;
            System.out.println(String.format("Player \"%s\" win!", getAliveCharacters().get(0).getCharacter().getName()));
            System.out.println("Game Over!");
        }
    }
}