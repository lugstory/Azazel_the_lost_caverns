package world;

import game.Game;
import items.Item;

import java.util.List;

/**
 * A chest with some rewards.
 */
public class Chest {
    private List<Item> rewards;

    public Chest(List<Item> rewards) {
        this.rewards = rewards;
    }

    /**
     * Unlocks the chest
     */
    public void unlock(Game game){
        rewards.forEach(reward -> game.getCurrentRoom().addItem(reward));
    }

    public List<Item> getRewards() {
        return rewards;
    }

    public void setRewards(List<Item> rewards) {
        this.rewards = rewards;
    }
}
