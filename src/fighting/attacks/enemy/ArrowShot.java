package fighting.attacks.enemy;

import fighting.MiniGame;
import game.Player;

import java.io.Serializable;

public class ArrowShot extends EnemyAttack implements Serializable {
    public ArrowShot() {
        super("Arrow Shot", 2);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("An arrow is flying toward you! Try to dodge!");

        boolean dodged = MiniGame.start(1);

        if (dodged) {
            System.out.println("You rolled to the side and dodged the arrow!");
        } else {
            System.out.println("The arrow hits you. -"+getDamage()+" health.");
            player.setHealth(player.getHealth() - getDamage());
        }
    }
}
