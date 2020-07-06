package course.battlegame;

abstract public class Character {
    private final String name;
    private static Integer DEFAULT_MAX_HEATPOINTS = 100;
    protected final Integer maxHeatPoint;
    protected Integer heatPoints;

    Character(String name, Integer maxHeatPoint) {
        this.name = name;

        if (maxHeatPoint <= 0) {
            this.heatPoints = Character.DEFAULT_MAX_HEATPOINTS;
            this.maxHeatPoint = Character.DEFAULT_MAX_HEATPOINTS;

            return;
        }

        this.heatPoints = maxHeatPoint;
        this.maxHeatPoint = maxHeatPoint;
    }

    public String getName() {
        return this.name;
    }

    public Integer getHeatPoints() {
        return this.heatPoints;
    }

    public Integer getMaxHeatPoint() {
        return this.maxHeatPoint;
    }

    abstract protected void changeHeatPoints(Character character, Integer heatPoints);
    abstract void step(Position[] positions);
}