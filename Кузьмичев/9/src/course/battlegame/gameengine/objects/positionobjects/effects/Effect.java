package course.battlegame.gameengine.objects.positionobjects.effects;

import course.battlegame.gameengine.transactions.ActionTransaction;

public interface Effect {
    ActionTransaction getEffectedTransactions(ActionTransaction transaction);
}