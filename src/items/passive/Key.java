package items.passive;

import game.Player;
/**
 * This item is only used for the open command
 */
public class Key extends PassiveItem{

    public Key() {
        super("Key", "Allows you to open chests with \"open\".");
    }

    @Override
    public void applyEffect(Player player) {
        System.out.println("Use the \"open\" command to use a key.");
    }
}
