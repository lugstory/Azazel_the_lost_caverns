package world.npcs;

public abstract class NPC {
    private final String name;

    public NPC(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
