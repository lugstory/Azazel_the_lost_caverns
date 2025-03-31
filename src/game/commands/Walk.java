package game.commands;

import game.Game;
import world.rooms.Room;

import java.util.Map;

public class Walk implements Command{

    @Override
    public void execute(Game game, String[] args) {
        int direction = getIntFromDir(args[0]);
        Room currentRoom = game.getCurrentRoom();
        Room[] allRooms = game.getAllRooms();
        Room targetRoom = allRooms[currentRoom.getNeighborsIndexes().get(direction)];
        if (targetRoom!=null){
            game.setCurrentRoom(targetRoom);
        }
    }
    private static final Map<String, Integer> directionMap = Map.of(
            "north", 0,
            "east", 1,
            "south", 2,
            "west", 3
    );

    private int getIntFromDir(String direction) {
        return directionMap.getOrDefault(direction, -1); // Vrací -1, pokud není nalezena žádná odpovídající hodnota
    }


}
