package items.passive;

import game.Player;

import java.io.Serializable;

public class Knife extends PassiveItem implements Serializable {
    public Knife() {
        super("A knife.","A knife capable of stabbing your enemies.");
    }

    @Override
    public void applyEffect(Player player) {
        System.out.println("Your spider amulet activated and grants you +2 max health and heals you by 2.");
        player.setMaxHealth(player.getMaxHealth() + 2);
        player.setHealth(player.getHealth() + 2);
    }
}
