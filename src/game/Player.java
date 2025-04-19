package game;

import fighting.attacks.player.PlayerAttack;
import items.active.ActiveItem;
import items.passive.PassiveItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents the Player, with fields that are crucial for the game
 */
public class Player  {
    private int health; // The current health
    private int maxHealth; // The maximum health
    private int damage; // The damage multiplier
    private int luck;

    private final List<PassiveItem> passiveItems;
    private ActiveItem activeItem;

    private final List<PlayerAttack> attacks;

    public Player() {
        this.maxHealth = 12;
        this.health = maxHealth;
        this.damage = 1;
        this.luck = 0;
        this.passiveItems = new ArrayList<>();
        this.attacks = new ArrayList<>();
        this.activeItem = null;
    }

    // ==== Health ====
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, maxHealth));
    }

    // ==== Max Health ====
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        if (this.health > maxHealth) {
            this.health = maxHealth;
        }
    }

    // ==== Damage and Luck ====
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(1, damage);
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = Math.max(0, luck);
    }


    // ==== Passive items ====
    public void addPassiveItem(PassiveItem item) {
        passiveItems.add(item);
        item.applyEffect(this);
    }

    public List<PassiveItem> getPassiveItems() {
        return passiveItems;
    }

    // ==== Active item ====
    public ActiveItem getActiveItem() {
        return activeItem;
    }

    public void setActiveItem(ActiveItem activeItem) {
        this.activeItem = activeItem;
    }

    public void reduceActiveItemCooldown() {
        if (activeItem != null) {
            activeItem.reduceCooldown();
        }
    }

    // ==== Attacks ====
    public List<PlayerAttack> getAttacks() {
        return attacks;
    }

    public void addAttack(PlayerAttack attack) {
        attacks.add(attack);
    }

    public void removeAttack(PlayerAttack attack) {
        attacks.remove(attack);
    }
}
