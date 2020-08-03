package main.transactions;

import main.objects.characters.Character;

public abstract class WeaponTransaction extends Transaction {
    private Character transactionCreator;
    private Character transactionGetter;

    public WeaponTransaction(Character transactionCreator, Character transactionGetter) {
        this.transactionCreator = transactionCreator;
        this.transactionGetter = transactionGetter;
    }

    public Character getActionCreator() {
        return transactionCreator;
    }

    public Character getActionGetter() {
        return transactionGetter;
    }
}
