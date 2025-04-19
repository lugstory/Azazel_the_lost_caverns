package fighting.attacks.player;

import fighting.MiniGame;
import game.Player;
import world.npcs.Enemy;

public class HeavySmash extends PlayerAttack  {
    public HeavySmash() {
        super("Heavy Smash", 5);
    }

    @Override
    public boolean execute(Player player, Enemy target) {
        try {
            Thread.sleep(800);
            System.out.println("You’re charging up a powerful smash!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return MiniGame.start(2); // normální čas, ale vyšší odměna
    }
}
