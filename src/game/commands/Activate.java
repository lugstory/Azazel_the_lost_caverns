package game.commands;

import game.Game;
import world.rooms.Room;

import java.util.Map;

public class Activate implements Command{
    public Activate() {}

    @Override
    public void execute(Game game, String[] args) {
        game.activateActiveItem();
    }
    @Override
    public String getUsage() {
        return "activate, activates your active item";
    }
}
