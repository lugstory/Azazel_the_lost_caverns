package fighting.attacks.enemy;

import fighting.CombatManager;
import fighting.MiniGame;
import game.Player;

import java.io.Serializable;

public class Fireball extends EnemyAttack implements Serializable {
    public Fireball() {
        super("Fireball", 2); // Damage is set to 2 for fireball
    }

    @Override
    public void executeOnPlayer(Player player) {
        System.out.println("The enemy casts a fireball at you! Try to dodge!");
        CombatManager.pressEnter();

        boolean dodged = MiniGame.start(1);

        if (dodged) {
            System.out.println("You narrowly avoided the fireball!");
        } else {
            System.out.println("The fireball hits you and burns your skin. -"+getDamage()+" health.");
            player.setHealth(player.getHealth() - getDamage());
        }
    }
}
