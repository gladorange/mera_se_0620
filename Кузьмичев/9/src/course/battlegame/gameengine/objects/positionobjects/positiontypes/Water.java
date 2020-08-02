package course.battlegame.gameengine.objects.positionobjects.positiontypes;

import course.battlegame.gameengine.transactions.ActionTransaction;

public class Water extends PositionType {
    @Override
    public ActionTransaction getEffectedTransactions(ActionTransaction transaction) {
        return transaction;
    }
}
