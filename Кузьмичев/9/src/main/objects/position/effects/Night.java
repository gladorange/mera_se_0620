package main.objects.position.effects;

import main.transactions.WeaponTransaction;

public class Night implements Effect {
    @Override
    public WeaponTransaction getEffectedTransactions(WeaponTransaction transaction) {
        return transaction;
    }
}