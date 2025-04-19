package items.passive;

import game.Player;
import items.Item;
/**
 * A class that inherits from Item and represents a passive item that is most likely going to be applied once
 */
public class PassiveItem extends Item  {
    public PassiveItem(String name, String description) {
        super(name,description);
    }
    public void applyEffect(Player player){};
}
