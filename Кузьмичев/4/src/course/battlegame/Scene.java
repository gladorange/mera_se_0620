package course.battlegame;

public class Scene {
    private static Integer DEFAULT_NUM_POSITIONS = 2;
    private final Integer maxPositions;
    private final Position[] battlefield;
    private Integer currentCharacter;
    private Boolean isEndGame = false;

    {
        this.currentCharacter = 0;
    }

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
            this.battlefield[i] = new Position();
            this.battlefield[i].setPositionNumber(i + 1);
        }
    }

    public Integer getMaxPositions() {
        return this.maxPositions;
    }

    public Character setCharacter(Character character) {
        return setCharacter(character, 0);
    }

    public Character getCharacter(String name) {
        for (Position pos: battlefield) {
            if(pos.getCharacter().getName().equals(name)) {
                return pos.getCharacter();
            }
        }

        return null;
    }

    public Character getCharacter(Integer position) {
        if (battlefield[position].getTaken()) {
            return battlefield[position].getCharacter();
        }

        return null;
    }

    public Character setCharacter(Character character, Integer position) {
        if(!(position <= 0) & !battlefield[position].getTaken()) {
            battlefield[position].setCharacter(character);
            return character;
        }

        for (Position pos: battlefield) {
            if (pos.getTaken().equals(false)) {
                pos.setCharacter(character);
                return character;
            }
        }

        return null;
    }

    public Boolean getEndGame() {
        return this.isEndGame;
    }

    public void gameStep() {
        if (this.isEndGame) {
            System.out.println("Game Over!");
            return;
        }

        for (Position pos: this.battlefield) {
            if (pos.getTaken() && pos.getCharacter().getHeatPoints().equals(0)) {
                System.out.println("Player \"" + pos.getCharacter().getName() + "\" was killed");
                pos.removeCharacter();
            }
        }

        Position position = battlefield[++currentCharacter % battlefield.length];

        while (!position.getTaken()) {
            position = battlefield[++currentCharacter % battlefield.length];
        }

        Integer alivePlayersNum = 0;

        for(Position pos: battlefield){
            if(pos.getTaken()) {
                alivePlayersNum++;
            }
        }

        if(alivePlayersNum.equals(1)) {
            this.isEndGame = true;
            System.out.println("Game Over!");
            return;
        }

        Position[] alivePlayers = new Position[alivePlayersNum];

        for(Position pos: battlefield){
            if(pos.getTaken()) {
                alivePlayers[--alivePlayersNum] = pos;
            }
        }

        position.getCharacter().step(alivePlayers);

    }
}