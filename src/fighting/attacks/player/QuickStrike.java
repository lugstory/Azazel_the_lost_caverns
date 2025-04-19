package fighting.attacks.player;

import fighting.MiniGame;
import game.Player;
import world.npcs.Enemy;

public class QuickStrike extends PlayerAttack  {
    public QuickStrike() {
        super("Quick Strike", 2);
    }

    @Override
    public boolean execute(Player player, Enemy target) {
        try {
            Thread.sleep(300);
            System.out.println("Quick attack! Type the letter fast!");
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return MiniGame.start(1); // kratší časový limit
    }
}
