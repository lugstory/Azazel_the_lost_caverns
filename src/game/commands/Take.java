package game.commands;

import game.Game;
import items.Item;
import items.active.ActiveItem;
import items.passive.PassiveItem;
import world.rooms.Room;

import java.util.List;

/**
 * Command to take an item from the current room and add it to the player's inventory.
 * It checks if the item exists in the room and whether the player can pick it up.
 */
public class Take implements Command {

    /**
     * Executes the take command to pick up an item from the current room.
     * The item is identified by the index provided in the command arguments.
     *
     * @param game The current game state.
     * @param args The command arguments where args[0] is the item index.
     */
    @Override
    public void execute(Game game, String[] args) {
        Room currentRoom = game.getCurrentRoom();
        List<Item> items = currentRoom.getItems();

        // Check if there are items in the room
        if (items.isEmpty()) {
            System.out.println("There are no items to take.");
            return;
        }

        try {
            // Parse the item index from the arguments
            int index = Integer.parseInt(args[0]);

            // Check if the index is valid
            if (index < 0 || index >= items.size()) {
                System.out.println("Invalid item index.");
                return;
            }

            // Get the item and remove it from the room
            Item item = items.get(index);
            items.remove(item);

            // Add the item to the player's inventory, either as a PassiveItem or ActiveItem
            if (item instanceof PassiveItem) {
                game.getPlayer().addPassiveItem((PassiveItem) item);
            } else {
                game.getPlayer().setActiveItem((ActiveItem) item);
            }

            System.out.println("You picked up: " + item.getName());

        } catch (NumberFormatException e) {
            // Handle invalid input when the index is not a valid number
            System.out.println("Invalid input. Use a number to specify the item index.");
        }
    }

    /**
     * Provides the usage instructions for the take command.
     *
     * @return The string describing how to use the take command.
     */
    @Override
    public String getUsage() {
        return "take <index> - Takes the item at the specified index.";
    }
}
