public class HealingSpell extends Spell{
    @Override
    public String spellTitle(){
        return "\"Исцеление\"";
    }

    @Override
    public void cast(GameCharacter[] players, int playerId) {
        System.out.println("Добавляет очков здоровья магу, произнесшему заклинания");
        players[playerId].health++;
        System.out.println("Маг " + players[playerId].name + " исцелен на 1. Теперь у него " +
                players[playerId].health + " здоровья");
    }
}
