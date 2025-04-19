package fighting.attacks.player;

import fighting.CombatManager;
import fighting.MiniGame;
import game.Player;
import world.npcs.Enemy;

public class BasicAttack extends PlayerAttack  {
    private boolean firstTime = true;
    public BasicAttack() {
        super("Basic attack", 3);
    }

    @Override
    public boolean execute(Player player, Enemy target) {
        if (firstTime) {
            System.out.println("In order to perform the attack, you have to play a mini-game.\n" +
                    "A letter will appear on screen and you will have to write the letter and press enter at the same time.");
            CombatManager.pressEnter();
        }
        firstTime = false;

        return MiniGame.start(2);
    }
}
