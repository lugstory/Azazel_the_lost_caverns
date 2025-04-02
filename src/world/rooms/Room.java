package world.rooms;

import items.Item;
import world.npcs.NPC;

import java.util.List;

public abstract class Room {
    private Type type;
    private List<Item> items;
    private List<NPC> npcs;
    private List<Integer>  neighborsIndexes; //implement this with a set orientation, so that you can use directions to
                                             //move to different rooms, eg. null,null,Room,null => south has a room
                                             //dont forget to implement big rooms

    public List<Integer> getNeighborsIndexes() {
        return neighborsIndexes;
    }
}
