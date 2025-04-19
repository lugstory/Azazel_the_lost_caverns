package world.npcs.enemies;

import fighting.attacks.enemy.Fireball;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class Teller extends Enemy {
    public Teller() {
        super("Teller", 20, new ArrayList<>());
        this.getAttacks().add(new Fireball());
    }

    @Override
    public void onDeath(Game game) {
        System.out.println("This was the last enemy before the boss fight, good luck!");
    }
}
