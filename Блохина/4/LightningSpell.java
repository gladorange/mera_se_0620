public class LightningSpell extends Spell {
    @Override
    public String spellTitle(){
        return "\"Молния\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        int affectedPlayerId = GameCharacter.getHitPlayerId(players, playerId, players.length);

        System.out.println("Наносит урон любому персонажу");
        int health = GameCharacter.attack(players[playerId], players[affectedPlayerId]);
        String msg = spellTitle() + " ударяет по " + players[affectedPlayerId].name + " и наносит урон " +
                players[playerId].damage + ". Оставшееся количество жизней: " + health;
        GameCharacter.printOutResult(players[affectedPlayerId], msg);
    }
}
