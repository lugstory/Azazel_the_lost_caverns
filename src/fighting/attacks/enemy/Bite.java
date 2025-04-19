package fighting.attacks.enemy;

import game.Player;

public class Bite extends EnemyAttack {

    public Bite() {
        super("Bite", 3);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("The enemy bit you! You lost " + getDamage() + " HP.");
        player.setHealth(player.getHealth()-getDamage());
    }
}
