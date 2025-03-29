package world.rooms;

import items.Item;
import world.npcs.NPC;

import java.util.List;

public abstract class Room {
    private List<Item> items;
    private List<NPC> npcs;
    private List<Integer>  neighborsIndexes;
}
