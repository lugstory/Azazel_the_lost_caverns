package fighting.attacks.enemy;

import game.Player;

public class GroundSmash extends EnemyAttack {
    public GroundSmash() {
        super("Ground Smash", 3);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("The enemy smashes the ground with force, shaking your bones. You take "+getDamage()+" damage!");
        player.setHealth(player.getHealth() - getDamage());
    }
}
