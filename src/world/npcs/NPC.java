package world.npcs;

/**
 * A basic NPC class
 */
public abstract class NPC  {
    private final String name;

    public NPC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
