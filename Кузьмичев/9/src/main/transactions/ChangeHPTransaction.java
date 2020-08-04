package main.transactions;

import main.objects.Character;

public class ChangeHPTransaction extends WeaponTransaction {
    private Integer hitPoints;

    public ChangeHPTransaction(Character transactionCreator, Character transactionGetter, Class weaponClass, Integer hitPoints) {
        super(transactionCreator, transactionGetter, weaponClass);
        this.hitPoints = hitPoints;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }
}
