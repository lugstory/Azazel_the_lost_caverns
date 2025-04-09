package items;

import game.Player;

public abstract class PassiveItem extends Item {
    public abstract void applyEffect(Player player);
}
