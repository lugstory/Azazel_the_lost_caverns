package world.rooms;

import game.Game;
import items.passive.Bomb;
import items.passive.Key;

import java.util.ArrayList;
import java.util.Collections;

public class UltraSecretRoom extends Room{

    public UltraSecretRoom(Game game) {
        super(game, "Ultra Secret room", Type.SMALL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        updateList();
    }
    public void updateList(){
        this.setNeighborsIndexes(new ArrayList<>(Collections.nCopies(4, null)));
        addItem(new Key());
        addItem(new Bomb());
        addItem(new Bomb());
    }
}
