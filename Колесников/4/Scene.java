final class Scene {
    private static Creature[] battleField = new Creature[9];
    private static int livingCharacters = 0;

    static Creature[] getBattleField() {
        return battleField;
    }

    static void setBattleField(Creature creature, int battleFieldIndex) {
        battleField[battleFieldIndex] = creature;
    }

    static int getLivingCharacters() {
        return livingCharacters;
    }

    static void setLivingCharacters() {
        int count = 0;
        for (Creature i : battleField){
            if (i != null){
                count++;
            }
        }
        livingCharacters = count;
    }

    static void reduceLivingCharacters() {
        livingCharacters--;
    }
}

