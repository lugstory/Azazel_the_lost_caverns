package world.rooms;

import game.Game;
import items.Item;
import world.npcs.Enemy;
import world.npcs.NPC;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    private Game game;
    private String name;
    private Type type;
    private List<Item> items;
    private List<NPC> npcs;
    private List<Integer> neighborsIndexes;

    public Room(Game game, String name, Type type, List<Item> items, List<NPC> npcs, List<Integer> neighborsIndexes) {
        this.game = game;
        this.name = name;
        this.type = type;
        this.items = items;
        this.npcs = npcs;
        this.neighborsIndexes = neighborsIndexes;
    }
    public void look() {
        System.out.println("Available doors: ");
        for (Integer index : neighborsIndexes) {
            Room room = game.getAllRooms()[index];
            if (room != null) {
                System.out.println("Door number "+index);
            }
        }
        if (npcs.isEmpty() && items.isEmpty()) {
            System.out.println("This room is empty.");
        } else {
            if (!npcs.isEmpty()) {
                System.out.println("Enemies in the room:");
                for (NPC npc : npcs) {
                    System.out.println(" - " + npc.getName());
                }
            }

            if (!items.isEmpty()) {
                System.out.println("Items in the room:");
                for (Item item : items) {
                    System.out.println(" - " + item.getName());
                }
            }
        }
    }

    public Type getType() {
        return type;
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
}
