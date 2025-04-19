package world.npcs.enemies;

import fighting.attacks.enemy.ArrowShot;
import fighting.attacks.enemy.Fireball;
import fighting.attacks.enemy.GroundSmash;
import fighting.attacks.enemy.ToxicSpit;
import game.Game;
import world.npcs.Enemy;

import java.util.ArrayList;

public class Boss extends Enemy {
    public Boss() {
        super("boss", 30, new ArrayList<>());
        this.getAttacks().add(new Fireball());
        this.getAttacks().add(new ToxicSpit());
        this.getAttacks().add(new ArrowShot());
        this.getAttacks().add(new GroundSmash());

    }

    @Override
    public void onDeath(Game game) {
        System.out.println("Aaaaaugh, you beat this basement... \nNow.. I'll give you the secret.. Use the \"win\" command to leave this place..");
    }
}
