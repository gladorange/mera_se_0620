/*****************************************************************************
 * File: ArcherHumanPlayer.java
 * Purpose: For future implementation of human actions for a specific character
 * Notice: (c) 2020 Nikolay Kuzmichev. All rights reserved.
 *****************************************************************************/

package main.objects.players.human;

import main.actions.weapons.Weapon;

import main.objects.characters.AbstractArcher;
import main.objects.characters.AbstractCharacter;
import main.objects.Position;
import main.objects.characters.stuff.Stuff;

import main.transactions.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class ArcherHumanPlayer extends AbstractArcher {

    public ArcherHumanPlayer(String name, Integer maxHitPoint, ArrayList<Weapon> weapons) {
        super(name, maxHitPoint, weapons);
    }

    public ArcherHumanPlayer(String name, Integer maxHitPoint, Integer power, ArrayList<Weapon> weapons) {
        super(name, maxHitPoint, power, weapons);
    }

    public ArcherHumanPlayer(String name, Integer maxHitPoint, Integer power, ArrayList<Weapon> weapons, Stuff stuff) {
        super(name, maxHitPoint, power, weapons, stuff);
    }

    @Override
    public ArrayList<Transaction> act(Map<Position, AbstractCharacter> battlefield) {
        return null;
    }
}
