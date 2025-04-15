package world.npcs;

import fighting.attacks.enemy.EnemyAttack;

import java.util.List;
import java.util.Random;

public abstract class Enemy extends NPC {
    private int health;
    private List<EnemyAttack> attacks;
    private String dialog; // může být null

    public Enemy(String name, int health, List<EnemyAttack> attacks, String dialog) {
        super(name);
        this.health = health;
        this.attacks = attacks;
        this.dialog = dialog;
    }

    public Enemy(String name, int health, List<EnemyAttack> attacks) {
        this(name, health, attacks, null); // konstruktor bez dialogu
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public List<EnemyAttack> getAttacks() {
        return attacks;
    }

    public EnemyAttack getRandomAttack() {
        if (attacks.isEmpty()) return null;
        Random rand = new Random();
        return attacks.get(rand.nextInt(attacks.size()));
    }

    public String getDialog() {
        return dialog;
    }

    public boolean hasDialog() {
        return dialog != null && !dialog.isBlank();
    }

    public void setAttacks(List<EnemyAttack> attacks) {
        this.attacks = attacks;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }
}
