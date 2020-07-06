public class MagiciansBattle {

    public static void main(String[] args) {

        Scene.setBattleField(new Ktulhu("Ktulhu"), 1);
        Scene.setBattleField(new LightningWizard("Lightning"), 0);
        Scene.setBattleField(new FireWizard("Fire"), 7);
        Scene.setBattleField(new Druid("Druid"), 3);

        Scene.setLivingCharacters();
        gameLogic();
    }

    private static void gameLogic(){
        Creature[] scene = Scene.getBattleField();
        while(Scene.getLivingCharacters() > 1){
            for (Creature i : scene){
                if (i != null){
                    i.attack();

                }
            }
        }
        for (Creature i : scene){
            if (i != null){
                System.out.printf("%s win!%n", i.getName());

            }
        }
    }
}