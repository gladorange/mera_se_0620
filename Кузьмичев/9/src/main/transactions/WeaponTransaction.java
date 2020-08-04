/*********************************************************
 * File: WeaponTransaction.java
 * Purpose: General class of weapon transactions
 * Notice: (c) 2020 Nikolay Kuzmichev. All rights reserved.
 ********************************************************/

package main.transactions;

import main.objects.characters.AbstractCharacter;

public abstract class WeaponTransaction extends ChangeCharacterTransaction {
    private AbstractCharacter transactionCreator;
    private AbstractCharacter transactionGetter;

    private Class weaponClass;

    public WeaponTransaction(AbstractCharacter transactionCreator, AbstractCharacter transactionGetter, Class weaponClass) {
        this.transactionCreator = transactionCreator;
        this.transactionGetter = transactionGetter;
        this.weaponClass = weaponClass;
    }

    public AbstractCharacter getActionCreator() {
        return transactionCreator;
    }

    public AbstractCharacter getActionGetter() {
        return transactionGetter;
    }

    public Class getWeaponClass() {
        return weaponClass;
    }
}
