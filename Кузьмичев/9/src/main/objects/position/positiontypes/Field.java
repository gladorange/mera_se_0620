package main.objects.position.positiontypes;

import main.transactions.WeaponTransaction;

public class Field extends PositionType {
    @Override
    public WeaponTransaction getEffectedTransactions(WeaponTransaction transaction) {
        return transaction;
    }
}
