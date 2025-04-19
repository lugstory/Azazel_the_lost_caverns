package world.npcs.enemies;

import fighting.attacks.enemy.Bite;
import fighting.attacks.enemy.ToxicSpit;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class Dog extends Enemy {
    public Dog() {
        super("A dawg", 8, new ArrayList<>());
        this.getAttacks().add(new Bite());
        this.getAttacks().add(new ToxicSpit());

    }

    @Override
    public void onDeath(Game game) {

    }
}
