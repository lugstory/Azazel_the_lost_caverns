package game.commands;

import game.Game;
import world.rooms.Room;

public class Look implements Command {
    @Override
    public void execute(Game game, String[] args) {
        // Získání aktuální místnosti
        Room currentRoom = game.getCurrentRoom();

        // Prohlédnutí místnosti
        currentRoom.look();
    }

    @Override
    public String getUsage() {
        return "look - Looks through the room and lists all NPCs and items.";
    }
}
