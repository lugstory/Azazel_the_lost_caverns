package fighting.attacks.enemy;

import game.Player;

public class BasicHit extends EnemyAttack {

    public BasicHit() {
        super("Basic hit", 1);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("Player lost 1 health.");
        player.setHealth(player.getHealth()-getDamage());
    }
}
