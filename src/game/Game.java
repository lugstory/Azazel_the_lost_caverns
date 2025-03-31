package game;

import world.rooms.Room;

public class Game {
    private Player player;
    private Room[] allRooms;
    private Room currentRoom;

    public Room[] getAllRooms() {
        return allRooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }
    public Room getRoomAtIndex(int index) {
        return allRooms[index];
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
