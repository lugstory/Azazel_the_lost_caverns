package world.rooms;

import game.Game;
import items.Item;
import world.Chest;
import world.npcs.NPC;

import java.util.List;
/**
 * Abstract class representing a room in the game.
 * A room contains items, NPCs, chests, and has neighboring rooms that can be accessed.
 */
public abstract class Room {
    private transient Game game;
    private final String name;
    private final List<Item> items;
    private final List<NPC> npcs;
    private List<Integer> neighborsIndexes;
    private List<Chest> chests;

    public Room(Game game, String name, List<Item> items, List<NPC> npcs, List<Integer> neighborsIndexes) {
        this.game = game;
        this.name = name;
        this.items = items;
        this.npcs = npcs;
        this.neighborsIndexes = neighborsIndexes;
    }
    /**
     * Prints the details of the room: ASCII art, available doors (neighboring rooms), and items and NPCs in the room.
     */
    public void look() {
        System.out.println("Room "+name+":");
        System.out.println(asciiArt());
        System.out.println("Available doors: ");
        for (int i = 0; i < neighborsIndexes.size(); i++) {
            Integer index = neighborsIndexes.get(i);
            try{
                Room room = game.getAllRooms().get(index);
                if (room != null) {
                    System.out.println("Door to number " + i);
                }
            } catch (Exception e) {
                System.out.println("Door number "+i+" is empty.");
            }
        }
        if (npcs.isEmpty() && items.isEmpty()) {
            System.out.println("This room is empty.");
        } else {
            if (!npcs.isEmpty()) {
                System.out.println("Enemies in the room:");
                for (NPC npc : npcs) {
                    System.out.println(" - " + npc.getName()+" (index = "+this.npcs.indexOf(npc)+")");
                }
            }

            if (!items.isEmpty()) {
                System.out.println("Items in the room:");
                for (Item item : items) {
                    System.out.println(" - " + item.getName()+" ("+item.getClass().getSuperclass().getSimpleName()+")"+" (index = "+this.items.indexOf(item)+")");
                }
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public List<Integer> getNeighborsIndexes() {
        return neighborsIndexes;
    }
    public void removeNpc(NPC npc) {
        npcs.remove(npc);
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    /**
     * Returns a basic ASCII representation of the room layout.
     *
     * @return The ASCII art of the room.
     */
    public String asciiArt(){
        return """
                ╭─────────╮
                │    0    │
                │3       1│
                │    2    │
                ╰─────────╯
                """;
    }

    public List<Chest> getChests() {
        return chests;
    }

    public void setChests(List<Chest> chests) {
        this.chests = chests;
    }

    public void setNeighborsIndexes(List<Integer> neighborsIndexes) {
        this.neighborsIndexes = neighborsIndexes;
    }
    public void setGame(Game game){
        this.game = game;
    }
}
