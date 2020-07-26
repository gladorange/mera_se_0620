public class MigraineSpell extends Spell{
    @Override
    public String spellTitle(){
        return "\"Мигрень\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        System.out.println("Наносит урон всем магам");
        for (GameCharacter player : players) {
            if(player instanceof GameMagician) {
                if(player.health > 0) {
                    int health = GameCharacter.attack(players[playerId], player);
                    String msg = spellTitle() + " ударяет по " + player.name + " и наносит урон " +
                            players[playerId].damage + ". Оставшееся количество жизней: " + health;
                    GameCharacter.printOutResult(player, msg);
                }
            }
        }
    }
}
