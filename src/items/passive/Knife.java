package items.passive;

import fighting.attacks.player.Stab;
import game.Player;

public class Knife extends PassiveItem  {
    public Knife() {
        super("A knife.","A knife capable of stabbing your enemies.");
    }

    @Override
    public void applyEffect(Player player) {
        player.addAttack(new Stab());
    }
}
