package world.rooms;

import items.Item;
import world.npcs.NPC;

import java.util.List;

public class Room {
    private String name;
    private Type type;
    private List<Item> items;
    private List<NPC> npcs;
    private List<Integer> neighborsIndexes;

    public Room(String name, Type type, List<Item> items, List<NPC> npcs, List<Integer> neighborsIndexes) {
        this.name = name;
        this.type = type;
        this.items = items;
        this.npcs = npcs;
        this.neighborsIndexes = neighborsIndexes;
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
}
