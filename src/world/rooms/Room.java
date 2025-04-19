package world.rooms;

import game.Game;
import items.Item;
import world.Chest;
import world.npcs.Enemy;
import world.npcs.NPC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private Game game;
    private String name;
    private Type type;
    private List<Item> items;
    private List<NPC> npcs;
    private List<Integer> neighborsIndexes;
    private List<Chest> chests;

    public Room(Game game, String name, Type type, List<Item> items, List<NPC> npcs, List<Integer> neighborsIndexes) {
        this.game = game;
        this.name = name;
        this.type = type;
        this.items = items;
        this.npcs = npcs;
        this.neighborsIndexes = neighborsIndexes;
    }
    public void look() {
        System.out.println("Room:");
        System.out.println(asciiArt());
        System.out.println("Available doors: ");
        for (int i = 0; i < neighborsIndexes.size(); i++) {
            Integer index = neighborsIndexes.get(i);
            try{
                Room room = game.getAllRooms().get(index);
                if (room != null) {
                    System.out.println("Door to number " + i);
                }
            } catch (Exception e) {
                System.out.println("Door number "+i+" is empty.");
            }
        }
        if (npcs.isEmpty() && items.isEmpty()) {
            System.out.println("This room is empty.");
        } else {
            if (!npcs.isEmpty()) {
                System.out.println("Enemies in the room:");
                for (NPC npc : npcs) {
                    System.out.println(" - " + npc.getName());
                }
            }

            if (!items.isEmpty()) {
                System.out.println("Items in the room:");
                for (Item item : items) {
                    System.out.println(" - " + item.getName()+" ("+item.getClass().getSuperclass().getSimpleName()+")");
                }
            }
        }
    }

    public Type getType() {
        return type;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public List<Integer> getNeighborsIndexes() {
        return neighborsIndexes;
    }
    public void removeNpc(NPC npc) {
        npcs.remove(npc);
    }
    public void addItem(Item item){
        this.items.add(item);
    }
    public String asciiArt(){
        return """
                ╭─────────╮
                │    0    │
                │3       1│
                │    2    │
                ╰─────────╯
                """;
    }

    public List<Chest> getChests() {
        return chests;
    }

    public void setChests(List<Chest> chests) {
        this.chests = chests;
    }

    public void setNeighborsIndexes(List<Integer> neighborsIndexes) {
        this.neighborsIndexes = neighborsIndexes;
    }
}
