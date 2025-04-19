package items.passive;

import game.Player;

/**
 * This item is only used for the bomb command
 */
public class Bomb extends PassiveItem{

    public Bomb() {
        super("Bomb", "Allows you to find secret rooms with \"bomb <doorId>.\"");
    }

    @Override
    public void applyEffect(Player player) {
        System.out.println("Use the \"bomb <doorId>\" command to use a bomb.");
    }
}
