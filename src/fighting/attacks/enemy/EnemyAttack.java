package fighting.attacks.enemy;

import game.Player;

public abstract class EnemyAttack {
    private String name;
    private int damage;

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
     * Spustí útok na hráče.
     */
    public abstract void executeOnPlayer(Player player);
}
