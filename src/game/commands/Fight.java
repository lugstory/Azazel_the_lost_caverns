package game.commands;

import fighting.CombatManager;
import game.Game;
import world.npcs.Enemy;
import world.npcs.NPC;
import world.rooms.Room;

import java.util.Scanner;

public class Fight implements Command {

    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 1) {
            System.out.println("You must provide the enemy index. Example: fight 0");
            return;
        }

        int enemyIndex;
        try {
            enemyIndex = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid index format.");
            return;
        }

        Room currentRoom = game.getCurrentRoom();
        if (enemyIndex < 0 || enemyIndex >= currentRoom.getNpcs().size()) {
            System.out.println("Invalid enemy index.");
            return;
        }

        NPC npc = currentRoom.getNpcs().get(enemyIndex);
        if (!(npc instanceof Enemy)) {
            System.out.println("This NPC is not an enemy.");
            return;
        }

        Enemy enemy = (Enemy) npc;

        if (enemy.getDialog() != null) {
            System.out.println("Enemy "+enemy.getName()+" says: " + enemy.getDialog());
        }

        CombatManager.startCombat(game,enemy,new Scanner(System.in));

        System.out.println("The battle is over.");
    }

    @Override
    public String getUsage() {
        return "fight <enemyIndex> - starts combat with the selected enemy";
    }
}
