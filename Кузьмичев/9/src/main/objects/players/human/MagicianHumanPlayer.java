package main.objects.players.human;

import main.actions.weapons.Weapon;

import main.objects.Character;
import main.objects.Position;
import main.objects.characters.Magician;
import main.objects.characters.stuff.Stuff;

import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class MagicianHumanPlayer extends Magician {
    public MagicianHumanPlayer(String name, Integer maxHitPoint, ArrayList<Weapon> weapons) {
        super(name, maxHitPoint, weapons);
    }

    public MagicianHumanPlayer(String name, Integer maxHitPoint, Integer power, ArrayList<Weapon> weapons) {
        super(name, maxHitPoint, power, weapons);
    }

    public MagicianHumanPlayer(String name, Integer maxHitPoint, Integer power, ArrayList<Weapon> weapons, Stuff stuff) {
        super(name, maxHitPoint, power, weapons, stuff);
    }

    @Override
    public ArrayList<Transaction> act(Map<Position, Character> battlefield) {
        return null;
    }
}
