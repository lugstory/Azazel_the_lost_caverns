package game.commands;

import game.Game;

public interface Command {
    void execute(Game game, String[] args);

    default String getUsage() {
        return "No usage info."; // Můžeš přepsat v každém příkazu
    }
}
