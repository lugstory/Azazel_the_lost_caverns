package fighting.attacks.player;

import fighting.MiniGame;
import game.Player;
import world.npcs.Enemy;

import java.io.Serializable;
import java.util.Random;

public class LuckyShot extends PlayerAttack implements Serializable {
    public LuckyShot() {
        super("Lucky Shot", 3);
    }

    @Override
    public boolean execute(Player player, Enemy target) {
        try {
            System.out.println("Trying your luck...");
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        boolean success = MiniGame.start(2);
        if (!success) return false;

        Random rand = new Random();
        int chance = player.getLuck() * 10; // 10% za každý bod štěstí
        if (rand.nextInt(100) < chance) {
            System.out.println("Lucky strike! You deal double damage!");
            target.setHealth(target.getHealth() - getDamage()); // extra damage navíc
        }
        return true;
    }
}
