package game.commands;

import game.Game;
import world.rooms.Room;

/**
 * A class that uses the Room.look() to list all of the items, npcs and more from the room itself
 */
public class Look implements Command {
    @Override
    public void execute(Game game, String[] args) {
        // Get the current room
        Room currentRoom = game.getCurrentRoom();
        System.out.println("Current room id: "+game.getAllRooms().indexOf(currentRoom));
        System.out.println("All rooms: "+game.getAllRooms());
        // Look through the room
        currentRoom.look();
    }

    @Override
    public String getUsage() {
        return "look - Looks through the room and lists all NPCs and items.";
    }
}
