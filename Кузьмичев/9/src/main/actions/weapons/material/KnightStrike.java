package main.actions.weapons.material;

import main.actions.ActionDescriber;
import main.actions.weapons.Weapon;

import main.objects.Character;
import main.objects.Position;

import main.transactions.ChangeHPTransaction;
import main.transactions.InfoTransaction;
import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class KnightStrike extends Weapon {
    @Override
    public ActionDescriber getDescriber() {
        return MaterialWeaponList.KNIGHTSTRIKE;
    }

    @Override
    public ArrayList<Transaction> attack(Map<Position, Character> battlefield, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Position position : battlefield.keySet()) {
            Character target = battlefield.get(position);

            if (target != attacker) {
                transactions.add(new ChangeHPTransaction(attacker, target,this.getClass(), -attacker.getPower()));
                String message =String.format("Knight \"%s\" is attacking \"%s\" on %d hp.",
                        attacker.getName(), target.getName(), attacker.getPower());
                transactions.add(new InfoTransaction(message));
            }
        }

        return transactions;
    }
}
