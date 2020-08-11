import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameScene {

    public static void main(String[] args) {
        int stage = 1;
        Map<String, String> spellBookMagician = new HashMap<>();

        int charterArrayLength = GameCharacter.getRandom(2, GameCharacter.characterCounts);
        GameCharacter[] players = getPlayers(charterArrayLength);
        spellBookMagician = GameMagician.spellBook(players);
        System.out.println("Начало игры\nУчастников " + charterArrayLength + ":");
        for (GameCharacter player : players) {
            System.out.println("Игрок: " + player.name + ", количество жизней: " + player.health +
                    ", сила урона: " + player.getDamage());
        }

        int playersInGame = charterArrayLength;
        while(playersInGame > 1) {
            System.out.println("\n" + stage + " ЭТАП ИГРЫ");
            for(int i = 0; i < charterArrayLength; i++) {
                if(players[i].health > 0) {
                    if(players[i] instanceof GameMonster) {
                        GameMonster.stepOfMonster(players, i, charterArrayLength);
                    } else if (players[i] instanceof GameMagician) {
                        GameMagician.stepOfMagician(players, i,spellBookMagician);
                    }
                }
            }
            stage++;
            playersInGame = GameCharacter.getPlayersInGame(stage, players);
        }

        GameCharacter.getWinner(players);
    }

    private static GameCharacter[] getPlayers(int charterArrayLength) {
        GameCharacter[] players = new GameCharacter[charterArrayLength];
        for(int i = 0; i < charterArrayLength; i++) {
            int typeOfPlayer = new Random().nextInt(2);
            switch (typeOfPlayer) {
                case 0:
                    players[i] = new GameMagician("Magician" + i, GameCharacter.getRandom(1, 5));
                    break;
                case 1:
                    players[i] = new GameMonster("Monster" + i, GameCharacter.getRandom(1, 5));
                    break;
                default:
            }
        }
        return players;
    }
}
