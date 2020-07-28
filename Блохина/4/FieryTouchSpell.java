public class FieryTouchSpell extends Spell {
    @Override
    public String spellTitle(){
        return "\"Огненное касание\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        int affectedPlayerNextId = playerId + 1;
        int affectedPlayerPreviousId = playerId - 1;

        System.out.println("Наносит урон персонажу, стоящему на соседней с магом позиции");

        if(playerId != (players.length - 1) && players[affectedPlayerNextId].health > 0) {
            GameCharacter.attack(players[playerId], players[affectedPlayerNextId]);

            String msgPlayerNext = spellTitle() + " ударяет по " + players[affectedPlayerNextId].name + " и наносит урон " +
                    players[playerId].damage + ". Оставшееся количество жизней: " + players[affectedPlayerNextId].health;

            GameCharacter.printOutResult(players[affectedPlayerNextId], msgPlayerNext);
        } else if(playerId != 0 && players[affectedPlayerPreviousId].health > 0) {
            GameCharacter.attack(players[playerId], players[affectedPlayerPreviousId]);

            String msgPlayerPrevious = spellTitle() + " ударяет по " + players[affectedPlayerPreviousId].name + " и наносит урон " +
                    players[playerId].damage + ". Оставшееся количество жизней: " + players[affectedPlayerPreviousId].health;

            GameCharacter.printOutResult(players[affectedPlayerPreviousId], msgPlayerPrevious);
        } else {
            System.out.println("На соседних позициях персонажей нет - никому урон не наносится");
        }
    }
}
