package world.npcs.enemies;

import fighting.attacks.enemy.Bite;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class BigDog extends Enemy {
    public BigDog() {
        super("A big dawg", 15, new ArrayList<>());
        this.getAttacks().add(new Bite());

    }

    @Override
    public void onDeath(Game game) {

    }
}
