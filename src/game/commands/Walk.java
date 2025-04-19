package game.commands;

import game.Game;
import world.rooms.Room;

/**
 * Command to allow the player to walk through a door and enter a new room.
 * The player can specify which door they want to walk through by providing a door index.
 */
public class Walk implements Command {

    /**
     * Executes the walk command.
     * The player provides a door index, and if valid, they will move to the corresponding room.
     *
     * @param game The current game state.
     * @param args The command arguments, where args[0] is the door index.
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length < 1) {
            System.out.println("You must provide a door index. Example: walk 0");
            return;
        }

        int doorIndex;
        try {
            doorIndex = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            return;
        }

        Room currentRoom = game.getCurrentRoom();
        if (doorIndex < 0 || doorIndex >= currentRoom.getNeighborsIndexes().size()) {
            System.out.println("Invalid door index.");
            return;
        }

        Integer targetRoomId = currentRoom.getNeighborsIndexes().get(doorIndex);
        if (targetRoomId == null) {
            System.out.println("There's nothing behind this door...");
            return;
        }

        Room targetRoom = game.getRoomAtIndex(targetRoomId);
        game.setCurrentRoom(targetRoom);
        System.out.println("You entered a new room.");
    }

    /**
     * Provides the usage instructions for the walk command.
     *
     * @return The string describing how to use the walk command.
     */
    @Override
    public String getUsage() {
        return "walk <doorIndex> - Enters the room through the selected door (e.g. walk 0)";
    }
}
