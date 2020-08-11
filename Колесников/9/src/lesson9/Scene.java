package src.lesson9;

final class Scene {
    private Creature[] battleField = new Creature[9];
    private int livingCharacters = 0;

    public Scene() {
        setBattleField(new Ktulhu("Ktulhu",3, this), 3);
        setBattleField(new LightningWizard("Lightning", this), 1);
        setBattleField(new FireWizard("Fire", this), 6);
        setBattleField(new Druid("Druid", this), 5);
    }

    Creature[] getBattleField() {
        return battleField;
    }

    void setBattleField(Creature creature, int battleFieldIndex) {
        battleField[battleFieldIndex] = creature;
    }

    int getLivingCharacters() {
        return livingCharacters;
    }

    void setLivingCharacters() {
        int count = 0;
        for (Creature i : battleField){
            if (i != null){
                count++;
            }
        }
        livingCharacters = count;
    }

    void reduceLivingCharacters() {
        livingCharacters--;
    }
}

