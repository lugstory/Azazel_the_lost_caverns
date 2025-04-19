package game;

import world.rooms.Room;

import java.util.List;
/**
 * Represents the state of the game, including the player, the rooms, and the current room the player is in.
 * Handles interactions such as activating items and managing room navigation.
 */
public class Game  {
    private Player player;
    private List<Room> allRooms;
    private transient Room currentRoom;

    public Game(List<Room> allRooms, Room currentRoom) {
        this.player = new Player();
        this.allRooms = allRooms;
        this.currentRoom = currentRoom;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Player getPlayer() {
        return player;
    }
    public Room getRoomAtIndex(int index) {
        return allRooms.get(index);
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    /**
     * Activates the player's active item, if it is available and not on cooldown.
     *
     * @return True if the item was activated, false otherwise.
     */
    public boolean activateActiveItem() {
        if (player.getActiveItem() == null) {
            System.out.println("You don't have an active item.");
            return false;
        }
        if (!player.getActiveItem().isReady()) {
            System.out.println("Your item is still on cooldown ("+player.getActiveItem().getCooldown()+").");
            return false;
        }
        System.out.println("Activated the item.");
        player.getActiveItem().activate(this);
        return true;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setAllRooms(List<Room> allRooms) {
        this.allRooms = allRooms;
    }
    public void addRoom(Room room){
        this.allRooms.add(room);
    }

}
