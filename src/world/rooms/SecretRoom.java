package world.rooms;

import game.Game;
import items.passive.Bomb;
import items.passive.Key;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A secret room, found by bombind a closed door
 */
public class SecretRoom extends Room{

    public SecretRoom(Game game) {
        super(game, "Secret room", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        updateList();
    }
    public void updateList(){
        this.setNeighborsIndexes(new ArrayList<>(Collections.nCopies(4, null)));
        addItem(new Key());
        addItem(new Bomb());
        addItem(new Bomb());
    }
}
