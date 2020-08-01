package course.battlegame.gameengine.effects;

import course.battlegame.gameengine.transactions.ActionTransaction;

import java.util.ArrayList;

public class Night extends Effect {
    @Override
    public ArrayList<ActionTransaction> getEffectedTransactions(ArrayList<ActionTransaction> transactions) {
        return transactions;
    }
}