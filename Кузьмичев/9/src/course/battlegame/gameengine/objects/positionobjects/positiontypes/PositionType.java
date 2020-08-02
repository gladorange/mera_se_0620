package course.battlegame.gameengine.objects.positionobjects.positiontypes;

import course.battlegame.gameengine.transactions.ActionTransaction;

public abstract class PositionType {
    public abstract ActionTransaction getEffectedTransactions(ActionTransaction transaction);
}
