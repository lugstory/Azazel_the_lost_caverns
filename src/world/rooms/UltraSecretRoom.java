package world.rooms;

import game.Game;
import items.passive.Bomb;
import items.passive.Key;
import world.npcs.enemies.SecretGuy;

import java.util.ArrayList;
import java.util.Collections;
/**
 * An ultra secret room, found by bombind a closed door
 */
public class UltraSecretRoom extends Room{

    public UltraSecretRoom(Game game) {
        super(game, "Ultra Secret room", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        updateList();
        this.getNpcs().add(new SecretGuy());
    }
    public void updateList(){
        this.setNeighborsIndexes(new ArrayList<>(Collections.nCopies(4, null)));
        addItem(new Key());
        addItem(new Bomb());
        addItem(new Bomb());
    }
}
