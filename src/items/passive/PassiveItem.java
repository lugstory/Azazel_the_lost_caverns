package items.passive;

import game.Player;
import items.Item;

import java.io.Serializable;

public abstract class PassiveItem extends Item implements Serializable {
    public PassiveItem(String name, String description) {
        super(name,description);
    }
    public abstract void applyEffect(Player player);
}
