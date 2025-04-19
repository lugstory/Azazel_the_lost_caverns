package items.active;

import game.Game;
import items.Item;

/**
 * A class that inherits from Item and represents an active item with a cooldown
 */
public class ActiveItem extends Item  {
    protected int cooldown;
    protected int currentCooldown = 0;

    public ActiveItem(String name, String description, int cooldown) {
        super(name, description);
        this.cooldown = cooldown;
    }

    public ActiveItem(String name) {
        super(name);
    }

    public boolean isReady() {
        return currentCooldown <= 0;
    }

    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }

    public void resetCooldown() {
        this.currentCooldown = cooldown;
    }

    /**
     * Activates the item's ability
     */
    public void activate(Game game){}
}
