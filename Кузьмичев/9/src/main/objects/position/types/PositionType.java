package main.objects.position.types;

import main.transactions.WeaponTransaction;

public abstract class PositionType {
    public abstract WeaponTransaction getEffectedTransactions(WeaponTransaction transaction);
}
