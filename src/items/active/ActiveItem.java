package items.active;

import game.Game;
import items.Item;

import java.io.Serializable;

public abstract class ActiveItem extends Item implements Serializable {
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

    public abstract void activate(Game game); // může ovlivnit hráče, místnost atd.
}
