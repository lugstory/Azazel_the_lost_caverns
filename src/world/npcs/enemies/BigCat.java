package world.npcs.enemies;

import fighting.attacks.enemy.Bite;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class BigCat extends Enemy {
    public BigCat() {
        super("A big cat", 15, new ArrayList<>());
        this.getAttacks().add(new Bite());

    }

    @Override
    public void onDeath(Game game) {

    }
}
