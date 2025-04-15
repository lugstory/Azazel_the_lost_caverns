package game;

import world.rooms.Room;

public class Game {
    private Player player;
    private Room[] allRooms;
    private Room currentRoom;

    public Game(Room[] allRooms, Room currentRoom) {
        this.player = new Player();
        this.allRooms = allRooms;
        this.currentRoom = currentRoom;
    }

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

    public boolean activateActiveItem() {
        if (player.getActiveItem() == null) return false;
        if (!player.getActiveItem().isReady()) return false;
        player.getActiveItem().activate(this);
        return true;
    }
}
