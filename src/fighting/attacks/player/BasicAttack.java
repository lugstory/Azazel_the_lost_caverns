package fighting.attacks.player;

import fighting.MiniGame;
import game.Player;
import world.npcs.Enemy;

public class BasicAttack extends PlayerAttack{
    public BasicAttack() {
        super("Basic attack", 3);
    }

    @Override
    public boolean execute(Player player, Enemy target) {
        try {
            Thread.sleep(500);
            System.out.println("In order to perform the attack, you have to play a mini-game.\n" +
                    "A letter will appear on screen and you will have to write the letter and press enter at the same time.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MiniGame miniGame = new MiniGame();
        return miniGame.startGame(2);
    }
}
