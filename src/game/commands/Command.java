package game.commands;

import game.Game;

/**
 * A slightly modified Command design pattern, with a Game game parametr in the execute()
 * and another method that returns the usage of the command - getUsage()
 */
public interface Command {
    /**
     *executes the command
     */
    void execute(Game game, String[] args);

    /**
     * the usage of the command
     * @return the usage
     */
    default String getUsage() {
        return "No usage info."; //
    }
}
