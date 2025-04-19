package game;

import game.commands.Command;
import game.commands.CommandsList;
import game.commands.Win;

import java.util.Scanner;
/**
 * Handles the main game loop, where the player interacts with the game by entering commands.
 * Continues the game until the player's health reaches 0 or lower.
 */
public class GameLoop {

    private final Game game;
    private final CommandsList commandsList;
    private final Scanner scanner;

    public GameLoop(Game game) {
        this.game = game;
        this.commandsList = new CommandsList();
        this.scanner = new Scanner(System.in);
    }
    /**
     * Starts the game loop. Continuously prompts the player for commands until the player dies.
     * Processes the input, executes the corresponding command, and updates the game state.
     */
    public void start() {
        System.out.println();

        while (game.getPlayer().getHealth()>=1) {
            commandsList.printAllCommands();
            System.out.print("\n>> ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split(" ");
            if (parts.length == 0 || parts[0].isEmpty()) continue;

            String commandName = parts[0];
            String[] args = new String[parts.length - 1];
            System.arraycopy(parts, 1, args, 0, args.length);

            Command command = commandsList.getCommand(commandName.toLowerCase());

            if (command != null) {
                command.execute(game, args);
                if (command.getClass()== Win.class) break;
            } else {
                System.out.println("Unknown command.");
            }

        }
    }
}
