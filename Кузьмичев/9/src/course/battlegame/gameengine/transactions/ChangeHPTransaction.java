package course.battlegame.gameengine.transactions;

import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Character;

public class ChangeHPTransaction extends ActionTransaction {
    private Integer hitPoints;

    public ChangeHPTransaction(Character transactionCreator, Character transactionGetter, Integer hitPoints) {
        super(transactionCreator, transactionGetter);
        this.hitPoints = hitPoints;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }
}
