package game.commands;

import game.Game;
import items.Item;
import items.active.ActiveItem;
import items.passive.PassiveItem;
import world.rooms.Room;

import java.util.List;

public class Take implements Command {

    @Override
    public void execute(Game game, String[] args) {
        Room currentRoom = game.getCurrentRoom();
        List<Item> items = currentRoom.getItems();

        if (items.isEmpty()) {
            System.out.println("There are no items to take.");
            return;
        }

        try {
            int index = Integer.parseInt(args[0]);

            if (index < 0 || index >= items.size()) {
                System.out.println("Invalid item index.");
                return;
            }

            Item item = items.get(index);
            items.remove(item);
            if (item instanceof PassiveItem){
                game.getPlayer().addPassiveItem((PassiveItem) item);
            } else {
                game.getPlayer().setActiveItem((ActiveItem) item);
            }

            System.out.println("You picked up: " + item.getName());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Use a number to specify the item index.");
        }
    }
    @Override
    public String getUsage() {
        return "take <index> - Takes the item at the specified index.";
    }
}
