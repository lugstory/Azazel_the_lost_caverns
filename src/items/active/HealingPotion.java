package items.active;

import game.Game;

import java.io.Serializable;

public class HealingPotion extends ActiveItem implements Serializable {

    public HealingPotion() {
        super("Healing potion", "A potion that came from a different planet.\nReplenishes itself.",3);
    }

    @Override
    public void activate(Game game) {
        System.out.println("Used "+getName()+" to heal 5 HP.");
        game.getPlayer().setHealth(game.getPlayer().getHealth()+5);
    }
}
