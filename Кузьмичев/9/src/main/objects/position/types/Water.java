package main.objects.position.types;

import main.transactions.WeaponTransaction;

public class Water extends PositionType {
    @Override
    public WeaponTransaction getEffectedTransactions(WeaponTransaction transaction) {
        return transaction;
    }
}
