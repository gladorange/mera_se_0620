public class FireWallSpell extends Spell {
    @Override
    public String spellTitle(){
        return "\"Стена огня\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        System.out.println("Наносит урон всем персонажам на четных позициях");
        for(int i = 0; i < players.length; i++) {
            if(i != playerId) {
                if (i % 2 == 0 && players[i].health > 0) {
                    GameCharacter.attack(players[playerId], players[i]);
                    String msg = spellTitle() + " ударяет по " + players[i].name + " и наносит урон " +
                            players[playerId].damage + ". Оставшееся количество жизней: " + players[i].health;
                    GameCharacter.printOutResult(players[i], msg);
                }
            }
        }
    }
}
