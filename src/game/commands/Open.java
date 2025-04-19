package game.commands;

import game.Game;
import items.passive.Key;
import items.passive.PassiveItem;
import world.Chest;

/**
 * Command to open a chest in the current room if the player has a key.
 * It checks if the player has a key in their passive items and unlocks the chest if so.
 * If the chest contains rewards, they are displayed to the player; if not, a message is shown.
 */
public class Open implements Command {

    /**
     * Executes the open command to unlock a chest in the current room.
     * The chest is identified by the index provided in the command arguments.
     * If the player has a key, the chest is unlocked, and its contents are revealed.
     *
     * @param game The current game state.
     * @param args The command arguments where args[0] is the chest index.
     */
    @Override
    public void execute(Game game, String[] args) {
        try {
            // Parse the chest index from the arguments
            int index = Integer.parseInt(args[0]);
            Chest chest = game.getCurrentRoom().getChests().get(index);
            Key key = null;

            // Check if the player has a key in their passive items
            for (PassiveItem item : game.getPlayer().getPassiveItems()) {
                if (item instanceof Key) {
                    key = (Key) item;
                    break;
                }
            }

            // If a key is found, unlock the chest and reveal its contents
            if (key != null) {
                System.out.println("You unlocked a chest! The contents are:");
                if (!chest.getRewards().isEmpty()) {
                    chest.getRewards().forEach(reward ->
                            System.out.println(" - " + reward + " (" + reward.getClass().getSimpleName() + ")"));
                } else {
                    System.out.println("You unlocked a chest, but the contents are empty :(");
                }
                // Unlock the chest and remove it from the room
                chest.unlock(game);
                game.getCurrentRoom().getChests().remove(chest);
            } else {
                // If no key is found, print a message
                System.out.println("You need a key to unlock a chest!");
            }

        } catch (NumberFormatException e) {
            // Handle invalid input when the index is not a valid number
            System.out.println("Please specify a valid index.");
        } catch (IndexOutOfBoundsException e) {
            // Handle invalid chest index
            System.out.println("Invalid index.");
        }
    }

    /**
     * Provides the usage instructions for the open command.
     *
     * @return The string describing how to use the open command.
     */
    @Override
    public String getUsage() {
        return "open <chestIndex> - opens the chest with a key.";
    }
}
