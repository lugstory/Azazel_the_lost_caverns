package game.commands;

import game.Game;
import world.rooms.Room;

public class Walk implements Command {
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

    @Override
    public String getUsage() {
        return "walk <doorIndex> - Enters the room through the selected door (e.g. walk 0)";
    }
}
