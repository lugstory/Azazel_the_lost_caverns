package world.npcs.enemies;

import fighting.attacks.enemy.EnemyAttack;
import fighting.attacks.player.BasicAttack;
import world.npcs.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Skeleton extends Enemy {

    public Skeleton() {
        super("Skeleton", 10, new ArrayList<EnemyAttack>());
    }

}
