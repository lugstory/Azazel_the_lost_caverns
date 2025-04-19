package game.commands;

import game.Game;

public class Win implements Command{
    @Override
    public void execute(Game game, String[] args) {
        System.out.println("You found the command to win the game! congratulations!");
    }

    @Override
    public String getUsage() {
        return "sssh";
    }
}
