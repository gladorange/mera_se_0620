package course.battlegame;

import com.sun.istack.internal.Nullable;

public class Scene {
    public static Integer DEFAULT_NUM_POSITIONS = 2;
    private final Integer maxPositions;
    private final Position[] battlefield;
    private Integer currentCharacterPosition = 0;
    private Boolean isEndGame = false;

    public Scene() {
        this(DEFAULT_NUM_POSITIONS);
    }

    public Scene(Integer maxPositions) {
        if (maxPositions > 0) {
            this.maxPositions = maxPositions;
        }
        else {
           this.maxPositions = Scene.DEFAULT_NUM_POSITIONS;
        }

        battlefield = new Position[this.maxPositions];

        for (Integer i = 0; i < battlefield.length; i++) {
            this.battlefield[i] = new Position(i + 1);
        }
    }

    public Integer getMaxPositions() {
        return this.maxPositions;
    }

    @Nullable
    public Character getCharacter(String name) {
        for (Position pos: battlefield) {
            if(pos.getCharacter().getName().equals(name)) {
                return pos.getCharacter();
            }
        }

        return null;
    }

    @Nullable
    public Character getCharacter(Integer position) {
        if (battlefield[position].getTaken()) {
            return battlefield[position].getCharacter();
        }

        return null;
    }

    @Nullable
    public Character addCharacter(Character character) {
        return addCharacter(character, 0);
    }

    @Nullable
    public Character addCharacter(Character character, Integer position) {
        /**
         * If position of the battlefield is free for new player then it may be created
         */
        if(!(position <= 0) & !battlefield[position].getTaken()) {
            battlefield[position].setCharacter(character);
            return character;
        }
        /**
         * If position is not free for new player then start searching for free position
         */
        for (Position pos: battlefield) {
            if (pos.getTaken().equals(false)) {
                pos.setCharacter(character);
                return character;
            }
        }
        /**
         *  If position is not founded then return null
         */
        return null;
    }

    public Boolean getEndGame() {
        return this.isEndGame;
    }

    @Nullable
    private Position[] getAliveCharacters() {
        Integer alivePlayersNum = 0;

        for(Position pos: battlefield){
            if(pos.getTaken()) {
                alivePlayersNum++;
            }
        }

        if (alivePlayersNum.equals(0)) {
            return null;
        }

        Position[] alivePlayers = new Position[alivePlayersNum];

        for(Position pos: battlefield){
            if(pos.getTaken()) {
                alivePlayers[--alivePlayersNum] = pos;
            }
        }

        return alivePlayers;
    }

    public void gameStep() {
        if (this.getEndGame()) {
            System.out.println("Game Over!");
            return;
        }

        for (Position pos: this.battlefield) {
            if (pos.getTaken() && pos.getCharacter().getHitPoints().equals(0)) {
                System.out.println("Player \"" + pos.getCharacter().getName() + "\" was killed");
                pos.removeCharacter();
            }
        }

        Position position = battlefield[++currentCharacterPosition % battlefield.length];

        while (!position.getTaken()) {
            position = battlefield[++currentCharacterPosition % battlefield.length];
        }

        Position[] alivePlayers = getAliveCharacters();

        if(alivePlayers == null) {
            System.out.println("No alive players");
            return;
        }

        if(alivePlayers.length == 1) {
            this.isEndGame = true;
            System.out.println("Player \"" + alivePlayers[0].getCharacter().getName() + "\" win!");
            System.out.println("Game Over!");
            return;
        }

        position.getCharacter().step(alivePlayers);

    }
}