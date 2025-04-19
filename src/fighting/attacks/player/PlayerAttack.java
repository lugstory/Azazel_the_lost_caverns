package fighting.attacks.player;

import world.npcs.Enemy;
import game.Player;
/**
 * An abstract class PlayerAttack,
 * every class that extends this class should use the execute() mechanic.
 */
public abstract class PlayerAttack  {
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
     *
     * @param player the Player object
     * @param target the Enemy to execute on
     * @return a boolean whether or not the attack was successful
     */
    public abstract boolean execute(Player player, Enemy target);
}
