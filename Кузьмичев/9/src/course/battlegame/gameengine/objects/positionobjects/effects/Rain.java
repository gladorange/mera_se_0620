package course.battlegame.gameengine.objects.positionobjects.effects;

import course.battlegame.gameengine.transactions.ActionTransaction;

public class Rain implements Effect {
    @Override
    public ActionTransaction getEffectedTransactions(ActionTransaction transaction) {
        return transaction;
    }
}