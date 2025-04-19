package game.commands;

import game.Game;
import items.passive.Key;
import items.passive.PassiveItem;
import world.Chest;

public class Open implements Command{

    @Override
    public void execute(Game game, String[] args) {

        try {
            int index = Integer.parseInt(args[0]);
            Chest chest = game.getCurrentRoom().getChests().get(index);
            Key key = null;

            for (PassiveItem item : game.getPlayer().getPassiveItems()) {
                if (item instanceof Key) {
                    key = (Key) item;
                    break;
                }
            }
            if (key!=null){
                System.out.println("You unlocked a chest! The contents are:");
                if (!chest.getRewards().isEmpty()){
                    chest.getRewards().forEach(reward -> {
                        System.out.println(" - "+reward + " ("+reward.getClass().getSimpleName()+")");
                    });
                } else {
                    System.out.println("You unlocked a chest, but the contents are empty :(");
                }
                chest.unlock(game);
                game.getCurrentRoom().getChests().remove(chest);
            } else {
                System.out.println("You need a key to unlock a chest!");
            }

        } catch (NumberFormatException e){
            System.out.println("Please specify a valid index.");
        } catch (IndexOutOfBoundsException e){
            System.out.println("Invalid index.");
        }

    }

    @Override
    public String getUsage() {
        return "open <chestIndex> - opens the chest with a key.";
    }
}
