package world.rooms;

import game.Game;
import items.Item;
import world.npcs.NPC;

import java.util.List;

/**
 * A basic room used for making custom rooms in JSON
 */
public class BasicRoom extends Room{
    public BasicRoom(Game game, String name, List<Item> items, List<NPC> npcs, List<Integer> neighborsIndexes) {
        super(game, name, items, npcs, neighborsIndexes);
    }
}
