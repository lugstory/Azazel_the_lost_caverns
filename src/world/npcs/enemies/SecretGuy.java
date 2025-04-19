package world.npcs.enemies;

import fighting.attacks.enemy.Blessing;
import fighting.attacks.enemy.EnemyAttack;
import game.Game;
import game.Player;
import world.npcs.Enemy;

import java.util.ArrayList;
import java.util.List;

public class SecretGuy extends Enemy {

    public SecretGuy() {
        super("▓§ Secret Guy §▓", 5, new ArrayList<>(), "You found the Ultra Secret Room, congratulations.");
        attacks.add(new Blessing());
    }

    @Override
    public void onDeath(Game game) {
        Player p = game.getPlayer();
        System.out.println("The secret guy gave you +5 Max Health and +5 Health.");
        p.setMaxHealth(p.getMaxHealth()+5);
        p.setHealth(p.getHealth()+5);
    }
}
