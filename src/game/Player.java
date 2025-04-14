package game;

import fighting.attacks.PlayerAttack;
import items.ActiveItem;
import items.PassiveItem;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int health; // 0–12
    private int damage; // násobitel útoků
    private int luck;

    private List<PassiveItem> passiveItems;
    private ActiveItem activeItem;

    private List<PlayerAttack> attacks;

    public Player() {
        this.health = 6;
        this.damage = 1;
        this.luck = 0;
        this.passiveItems = new ArrayList<>();
        this.attacks = new ArrayList<>();
        this.activeItem = null;
    }

    // ==== Zdraví ====
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, 12)); // clamp na 0–12
    }

    // ==== Damage a Luck ====
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

    // ==== Passive itemy ====
    public void addPassiveItem(PassiveItem item) {
        passiveItems.add(item);
        item.applyEffect(this); // předpokládáme, že každý item něco dělá
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

    // ==== Útoky ====
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
