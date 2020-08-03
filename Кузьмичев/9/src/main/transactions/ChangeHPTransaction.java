package main.transactions;

import main.objects.characters.Character;

public class ChangeHPTransaction extends WeaponTransaction {
    private Integer hitPoints;

    public ChangeHPTransaction(Character transactionCreator, Character transactionGetter, Integer hitPoints) {
        super(transactionCreator, transactionGetter);
        this.hitPoints = hitPoints;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }
}
