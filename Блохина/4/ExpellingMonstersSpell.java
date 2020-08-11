public class ExpellingMonstersSpell extends Spell{
    final String SPELL_TITLE = "\"Изгнание монстров\"";

    @Override
    public String spellTitle(){
        return "\"Изгнание монстров\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        System.out.println("Наносит урон всем монстрам");
        for (GameCharacter player : players) {
            if(player instanceof GameMonster) {
                if(player.health > 0) {
                    int health = GameCharacter.attack(players[playerId], player);
                    String msg = SPELL_TITLE + " ударяет по " + player.name + " и наносит урон " +
                            players[playerId].damage + ". Оставшееся количество жизней: " + health;
                    GameCharacter.printOutResult(player, msg);
                }
            }
        }
    }
}
