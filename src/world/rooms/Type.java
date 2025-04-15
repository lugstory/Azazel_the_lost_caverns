package world.rooms;

public enum Type {
    SMALL(4),
    MEDIUM(6),
    LARGE(8);

    private final int size;

    Type(int i) {
        this.size = i;
    }
    public int getSize() {
        return size;
    }
}
