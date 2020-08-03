package main.objects.position.positiontypes;

import main.transactions.WeaponTransaction;

public abstract class PositionType {
    public abstract WeaponTransaction getEffectedTransactions(WeaponTransaction transaction);
}
