package fighting.attacks;

import world.npcs.Enemy;
import game.Player;

public abstract class PlayerAttack {
    private final String name;
    private final int damage; // základní poškození

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
     * Provede útok hráče na nepřítele. Poškození může být ovlivněno staty hráče.
     */
    public abstract boolean execute(Player player, Enemy target);
}
