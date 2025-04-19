package items.passive;

import game.Player;

public class Bomb extends PassiveItem{

    public Bomb() {
        super("Bomb", "Allows you to find secret rooms.");
    }

    @Override
    public void applyEffect(Player player) {
        System.out.println("Use the \"bomb <doorId>\" command to use a bomb.");
    }
}
