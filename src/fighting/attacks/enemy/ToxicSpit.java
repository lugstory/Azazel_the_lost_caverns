package fighting.attacks.enemy;

import fighting.CombatManager;
import fighting.MiniGame;
import game.Player;

public class ToxicSpit extends EnemyAttack {
    public ToxicSpit() {
        super("Toxic Spit", 1);
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("The enemy spits toxic goo at you! Try to dodge!");
        CombatManager.pressEnter();

        boolean dodged = MiniGame.start(1);

        if (dodged) {
            System.out.println("You barely dodged the toxic spit!");
        } else {
            System.out.println("The spit hits you and burns your skin. -"+getDamage()+" health.");
            player.setHealth(player.getHealth() - getDamage());
        }
    }
}
