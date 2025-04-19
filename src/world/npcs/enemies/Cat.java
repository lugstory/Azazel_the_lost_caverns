package world.npcs.enemies;

import fighting.attacks.enemy.Bite;
import fighting.attacks.enemy.ToxicSpit;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class Cat extends Enemy {
    public Cat() {
        super("A cat", 8, new ArrayList<>());
        this.getAttacks().add(new Bite());
        this.getAttacks().add(new ToxicSpit());

    }

    @Override
    public void onDeath(Game game) {

    }
}
