package main.transactions;

import main.objects.Character;

public abstract class WeaponTransaction extends ChangeCharacterTransaction {
    private Character transactionCreator;
    private Character transactionGetter;

    private Class weaponClass;

    public WeaponTransaction(Character transactionCreator, Character transactionGetter, Class weaponClass) {
        this.transactionCreator = transactionCreator;
        this.transactionGetter = transactionGetter;
        this.weaponClass = weaponClass;
    }

    public Character getActionCreator() {
        return transactionCreator;
    }

    public Character getActionGetter() {
        return transactionGetter;
    }

    public Class getWeaponClass() {
        return weaponClass;
    }
}
