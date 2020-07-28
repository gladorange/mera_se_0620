import com.sun.org.apache.xerces.internal.impl.xs.models.XSCMUniOp;

import java.util.concurrent.ThreadLocalRandom;

public class GameCharacter {
    String name;
    int health;
    int damage;
    static int characterCounts = 10;

    public GameCharacter(String name, int damage) {
        this.name = name;
        this.health = 10;
        this.damage = damage;
    }

    public String getName() {

        return name;
    }

    public int getHealth() {

        return health;
    }

    public int getDamage() {

        return damage;
    }

    public static int getRandom(int begin, int end){

        return ThreadLocalRandom.current().nextInt(begin, end);
    }

    public static int getRandom(int randomNumber){
        return getRandom(1, randomNumber);
    }

    public static int getPlayersInGame(int stage, GameCharacter[] players) {
        int playersInGame = 0;
        StringBuilder endOfStageMsg = new StringBuilder();
        endOfStageMsg.append("\nВ " + stage + " этап переходят:");
        for (GameCharacter player : players) {
            if(player.health > 0) {
                endOfStageMsg.append("\n" + player.name + ", количество жизней: " + player.health);
                playersInGame++;
            }
        }
        if(playersInGame > 1) {
            System.out.println(endOfStageMsg);
        }
        return playersInGame;
    }

    protected static int getHitPlayerId(GameCharacter[] players, int playerId, int charterArrayLength) {
        int hitPlayerId = getRandom(0, charterArrayLength);
        if (playerId == hitPlayerId) {
            for (int j = 0; j < players.length; j++) {
                if (players[j].health > 0 && playerId != j) {
                    return hitPlayerId = j;
                }
            }
        }
        while(players[hitPlayerId].health <= 0) {
            hitPlayerId = getHitPlayerId(players, playerId, charterArrayLength);
        }
        return hitPlayerId;
    }

    public static int attack(GameCharacter attacker, GameCharacter attacked) {
        return attacked.health -= attacker.damage;
    }

    public static void getWinner(GameCharacter[] players) {
        for (GameCharacter player : players) {
            if(player.health>0) {
                System.out.println("\nПОБЕДИТЕЛЬ: " + player.name);
            }
        }
    }

    public static boolean checkKilled(GameCharacter player) {
        if(player.health <= 0) {
            player.health = 0;
            return true;
        }
        return false;
    }

    public static void printOutResult(GameCharacter player, String msg) {
        if(GameCharacter.checkKilled(player)) {
            System.out.println(player.name + " убит");
        } else if(msg != null){
            System.out.println(msg);
        }
    }

}
