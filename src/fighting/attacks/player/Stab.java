package fighting.attacks.player;

import fighting.MiniGame;
import game.Player;
import world.npcs.Enemy;

import java.util.Random;

public class Stab extends PlayerAttack  {
    public Stab() {
        super("Stab", 5);
    }

    @Override
    public boolean execute(Player player, Enemy target) {
        boolean success = MiniGame.start(1);
        if (!success) {
            System.out.println("You missed!");
            return false;
        }
        Random rand = new Random();
        int chance = 50;
        if (rand.nextInt(100) < chance) {
            System.out.println("Your knife was ineffective!");
            target.setHealth(target.getHealth() - getDamage()/2); // less damage
        } else {
            System.out.println("You stabbed the enemy.");
            target.setHealth(target.getHealth() - getDamage());
        }
        return true;

    }
}
