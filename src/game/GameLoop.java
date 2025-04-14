package game;

import game.commands.Command;
import game.commands.CommandsList;

import java.util.Map;
import java.util.Scanner;

public class GameLoop {

    private final Game game;
    private final CommandsList commandsList;
    private final Scanner scanner;

    public GameLoop(Game game) {
        this.game = game;
        this.commandsList = new CommandsList();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Vítej v Azazel – the lost caverns!");
        System.out.println("Nasťa ti drží palce 💘");
        System.out.println();

        while (true) {
            commandsList.printAllCommands();
            System.out.print("\nZadej příkaz: ");
            String input = scanner.nextLine();
            String[] parts = input.trim().split(" ");
            if (parts.length == 0 || parts[0].isEmpty()) continue;

            String commandName = parts[0];
            String[] args = new String[parts.length - 1];
            System.arraycopy(parts, 1, args, 0, args.length);

            Command command = commandsList.getCommand(commandName.toLowerCase());
            if (command != null) {
                command.execute(game, args);
            } else {
                System.out.println("Neznámý příkaz.");
            }
        }
    }
}
