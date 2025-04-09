package items;

import game.Game;

public abstract class ActiveItem extends Item {
    protected int cooldown;
    protected int currentCooldown = 0;

    public boolean isReady() {
        return currentCooldown <= 0;
    }

    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }

    public void resetCooldown() {
        this.currentCooldown = cooldown;
    }

    public abstract void activate(Game game); // může ovlivnit hráče, místnost atd.
}
