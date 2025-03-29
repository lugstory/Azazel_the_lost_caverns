package game.commands;

import game.Game;

public interface Command {
    void execute(Game game, String[] args);
}
