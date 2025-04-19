package items.active;

import game.Game;

/**
 * Heals the player +5, if health + 5 is larger than maxHealth, then health = maxHealth
 */
public class HealingPotion extends ActiveItem  {

    public HealingPotion() {
        super("Healing potion", "A potion that came from a different planet.\nReplenishes itself.",3);
    }

    @Override
    public void activate(Game game) {
        System.out.println("Used "+getName()+" to heal 5 HP.");
        currentCooldown=cooldown;
        int newHealth = game.getPlayer().getHealth() + 5;
        int maxHealth = game.getPlayer().getMaxHealth();

        game.getPlayer().setHealth(Math.min(newHealth, maxHealth));
    }
}
