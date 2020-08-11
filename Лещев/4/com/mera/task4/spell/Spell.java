package com.mera.task4.spell;

import com.mera.task4.character.Character;

public abstract class Spell {

    private final String name;

    protected Spell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void cast(Character caster) {
        if(caster == null) {
            throw new IllegalArgumentException();
        }
    }
}
