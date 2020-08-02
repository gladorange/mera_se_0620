package course.battlegame.gameengine.objects.positionobjects.positiontypes;

import course.battlegame.gameengine.transactions.ActionTransaction;

public class Mountain extends PositionType {
    @Override
    public ActionTransaction getEffectedTransactions(ActionTransaction transaction) {
        return transaction;
    }
}
