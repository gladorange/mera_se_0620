package main.objects.position.effects;

import main.actions.weapons.properties.FireProperty;

import main.transactions.ChangeHPTransaction;
import main.transactions.WeaponTransaction;

public class Rain implements Effect {
    @Override
    public WeaponTransaction getEffectedTransactions(WeaponTransaction transaction) {
        WeaponTransaction changedTransaction = transaction;
        if (transaction.getWeaponClass() == FireProperty.class) {
            if (transaction.getWeaponClass() == ChangeHPTransaction.class) {
                Integer effectedHP = ((ChangeHPTransaction) transaction).getHitPoints();
                if (effectedHP < 0) {
                    effectedHP = effectedHP / 2;
                }

                changedTransaction = new ChangeHPTransaction(transaction.getActionCreator(),
                        transaction.getActionGetter(), transaction.getWeaponClass(),
                        effectedHP);
            }
        }
        return changedTransaction;
    }
}