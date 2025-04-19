package world.npcs.enemies;

import fighting.attacks.enemy.ArrowShot;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class Skeleton extends Enemy {
    public Skeleton() {
        super("Skeleton", 8, new ArrayList<>());
        this.getAttacks().add(new ArrowShot());

    }

    @Override
    public void onDeath(Game game) {

    }
}
