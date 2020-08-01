package course.battlegame.gameengine.objects.positionobjects.effects;

import course.battlegame.gameengine.transactions.ActionTransaction;

import java.util.ArrayList;

public abstract class Effect {
    public abstract ArrayList<ActionTransaction> getEffectedTransactions(ArrayList<ActionTransaction> transactions);
}