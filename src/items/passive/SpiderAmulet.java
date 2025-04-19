package items.passive;

import game.Player;

public class SpiderAmulet extends PassiveItem  {
    public SpiderAmulet() {
        super("Spider Amulet","Created with 5 kilometers of spider silk.");
    }

    @Override
    public void applyEffect(Player player) {
        System.out.println("Your spider amulet activated and grants you +2 max health and heals you by 2.");
        player.setMaxHealth(player.getMaxHealth() + 2);
        player.setHealth(player.getHealth() + 2);
    }
}
