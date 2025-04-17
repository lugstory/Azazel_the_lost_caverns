package fighting.attacks.enemy;

import game.Player;

import java.io.Serializable;

public class Bite extends EnemyAttack implements Serializable {

    public Bite() {
        super("Bite", 3);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("The enemy bit you! You lost " + getDamage() + " HP.");
        player.setHealth(player.getHealth()-getDamage());
    }
}
