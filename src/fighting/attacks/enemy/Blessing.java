package fighting.attacks.enemy;

import game.Player;

public class Blessing extends EnemyAttack{
    public Blessing() {
        super("Blessing", 0);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("I'm not hurting you...");
    }
}
