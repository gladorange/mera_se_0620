package course.battlegame.gameengine.actions.spells;

import course.battlegame.gameengine.objects.Position;
import course.battlegame.gameengine.objects.positionobjects.characters.Character;
import course.battlegame.gameengine.transactions.ChangeHPTransaction;
import course.battlegame.gameengine.transactions.InfoTransaction;
import course.battlegame.gameengine.transactions.Transaction;

import java.util.ArrayList;

public class Healling extends Spell {
    public Healling() {
        super(SpellsList.HEALLING);
    }

    @Override
    public ArrayList<Transaction> attack(ArrayList<Position>  positions, Character attacker) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        if (getWeaponBlocked()) {
            transactions.add(new InfoTransaction(String.format("Spell \"%s\" has been casted by the character already.", getDescriber().getName())));
            return transactions;
        }

        transactions.add(new ChangeHPTransaction(attacker, attacker, attacker.getPower()));
        transactions.add(new InfoTransaction(String.format("Magician \"%s\" is healling self on %d hp.",
                attacker.getName(), attacker.getPower())));

        setWeaponBlocked(true);
        return transactions;
    }
}