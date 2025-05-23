package game.commands;

import game.Game;

public class Activate implements Command{
    public Activate() {}

    @Override
    public void execute(Game game, String[] args) {
        game.activateActiveItem();
    }
    @Override
    public String getUsage() {
        return "activate - Activates your active item.";
    }
}
