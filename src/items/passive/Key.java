package items.passive;

import game.Player;

public class Key extends PassiveItem{

    public Key() {
        super("Key", "Allows you to open chests.");
    }

    @Override
    public void applyEffect(Player player) {
        System.out.println("Use the \"open\" command to use a key.");
    }
}
