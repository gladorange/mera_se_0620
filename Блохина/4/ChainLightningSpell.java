public class ChainLightningSpell extends Spell{
    @Override
    public String spellTitle(){
        return "\"Цепная молния\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        System.out.println("Маг наносит урон " + players[playerId].damage + " всем персонажам, кроме себя");
        for (int i = 0; i < players.length; i++) {
            if (players[i] != players[playerId] && players[i].health > 0) {
                GameCharacter.attack(players[playerId], players[i]);
                GameCharacter.printOutResult(players[i], null);
            }
        }
    }

}
