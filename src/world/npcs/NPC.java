package world.npcs;

import java.io.Serializable;

public abstract class NPC implements Serializable {
    private final String name;

    public NPC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
