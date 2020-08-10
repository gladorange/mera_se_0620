package com.mera.task4.character;

import com.mera.task4.spell.*;

import java.util.concurrent.ThreadLocalRandom;

public class Magician extends Character {

    private final Spell[] spellBook;

    public Magician(String name, int health, Spell[] spells) {
        super(name, health);
        spellBook = spells;
    }

    @Override
    public void act() {
        if(spellBook == null) {
            return;
        }
        int spellIndex = (spellBook.length > 1) ? ThreadLocalRandom.current().nextInt(spellBook.length) : 0;
        System.out.println(String.format("Маг \"%s\" читает заклинание \"%s\".", getName(), spellBook[spellIndex].getName()));
        spellBook[spellIndex].cast(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Маг \"%s\" (%d очков здоровья), владеет заклинаниями:", getName(), getHealth()));
        for(Spell spell : spellBook) {
            sb.append("\"");
            sb.append(spell.getName());
            sb.append("\" ");
        }
        return sb.toString();
    }
}
