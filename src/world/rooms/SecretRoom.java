package world.rooms;

import game.Game;
import items.Item;
import items.passive.Bomb;
import items.passive.Key;
import world.npcs.NPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecretRoom extends Room{

    public SecretRoom(Game game) {
        super(game, "Secret room", Type.SMALL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        updateList();
    }
    public void updateList(){
        this.setNeighborsIndexes(new ArrayList<>(Collections.nCopies(4, null)));
        addItem(new Key());
        addItem(new Bomb());
        addItem(new Bomb());
    }
}
