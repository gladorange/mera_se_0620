package course.battlegame.gameengine.transactions;

import course.battlegame.gameengine.sceneobjects.positionobjects.characters.Character;

public abstract class ActionTransaction extends Transaction {
    private Character transactionCreator;
    private Character transactionGetter;

    public ActionTransaction(Character transactionCreator, Character transactionGetter) {
        this.transactionCreator = transactionCreator;
        this.transactionGetter = transactionGetter;
    }

    public Character getActionCreator() {
        return transactionCreator;
    }

    public Character getActionGetter() {
        return transactionGetter;
    }
}
