package course.battlegame.gameengine.objects.positionobjects.positiontype;

import course.battlegame.gameengine.transactions.ActionTransaction;

import java.util.ArrayList;

public class Field extends PositionType {
    @Override
    public ArrayList<ActionTransaction> getEffectedTransactions(ArrayList<ActionTransaction> transactions) {
        return transactions;
    }
}
