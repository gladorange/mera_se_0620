package main.objects.position.effects;

import main.transactions.WeaponTransaction;

public interface Effect {
    WeaponTransaction getEffectedTransactions(WeaponTransaction transaction);
}