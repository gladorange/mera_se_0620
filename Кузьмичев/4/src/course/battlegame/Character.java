package course.battlegame;

abstract public class Character {
    private final String name;
    private static Integer DEFAULT_MAX_HEATPOINTS;
    protected final Integer maxHitPoint;
    protected Integer hitPoints;

    {
        Character.DEFAULT_MAX_HEATPOINTS = 100;
    }

    Character(String name, Integer maxHitPoint) {
        this.name = name;

        if (maxHitPoint <= 0) {
            this.hitPoints = Character.DEFAULT_MAX_HEATPOINTS;
            this.maxHitPoint = Character.DEFAULT_MAX_HEATPOINTS;

            return;
        }

        this.hitPoints = maxHitPoint;
        this.maxHitPoint = maxHitPoint;
    }

    public String getName() {
        return this.name;
    }

    public Integer getHitPoints() {
        return this.hitPoints;
    }

    public Integer getMaxHitPoint() {
        return this.maxHitPoint;
    }

    abstract protected void changeHitPoints(Character character, Integer hitPoints);
    abstract void step(Position[] positions);
}