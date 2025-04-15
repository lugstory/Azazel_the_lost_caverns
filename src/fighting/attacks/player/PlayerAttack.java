package fighting.attacks.player;

import world.npcs.Enemy;
import game.Player;

public abstract class PlayerAttack {
    private final String name;
    private final int damage; // base damage

    public PlayerAttack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    /**
     * Attacks the enemy, may be influenced by the player's stats.
     */
    public abstract boolean execute(Player player, Enemy target);
}
