package fighting.attacks.enemy;

import game.Player;

/**
 * An abstract class EnemyAttack,
 * every class that extends this class should use the executeOnPlayer() mechanic.
 */
public abstract class EnemyAttack {
    private final String name;
    private final int damage;

    public EnemyAttack(String name, int damage) {
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
     * Executes the attack on the player.
     */
    public abstract void executeOnPlayer(Player player);
}
