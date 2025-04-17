package game.commands;

import game.Game;
import game.Player;

public class Info implements Command{
    Game game;
    @Override
    public void execute(Game game, String[] args) {
        this.game = game;
        Player player = game.getPlayer();
        System.out.println("---- Azazel ----");
        System.out.println(" - Health: "+player.getHealth()+"/"+player.getMaxHealth());
        System.out.println(passiveItemsString());
        if (game.getPlayer().getActiveItem() != null) {
            System.out.print(" - Active Item:: ");
            System.out.println(game.getPlayer().getActiveItem().getName()+": "+game.getPlayer().getActiveItem().getDescription());
        }
    }
    public String passiveItemsString(){
        StringBuilder itemsString = new StringBuilder();
        game.getPlayer().getPassiveItems().forEach(passiveItem -> {
            itemsString.append(" - ").append(passiveItem).append(": ").append(passiveItem.getDescription());
        });
        itemsString.insert(0," - Passive Items: ");
        return itemsString.toString();
    }
    @Override
    public String getUsage() {
        return "info - Shows you the info about Azazel.";
    }
}
