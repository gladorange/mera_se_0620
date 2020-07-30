public class GameMonster extends GameCharacter {

    public GameMonster(String name, int damage) {
        super(name, damage);
    }

    public static void stepOfMonster(GameCharacter[] players, int playerId, int charterArrayLength) {
        int hitPlayerId = getHitPlayerId(players, playerId, charterArrayLength);
        System.out.println("Монстр " + players[playerId].name + " атакует " + players[hitPlayerId].name +
                " на " + players[playerId].damage + " количество единиц здоровья");
        GameCharacter.attack(players[playerId], players[hitPlayerId]);
        GameCharacter.printOutResult(players[hitPlayerId], null);
    }
}
