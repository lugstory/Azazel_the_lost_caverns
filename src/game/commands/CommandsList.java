package game.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsList {
    private final Map<String, Command> commands;

    public CommandsList() {
        this.commands = new HashMap<>();
        registerCommand("walk", new Walk());
        registerCommand("activate", new Activate());
        registerCommand("fight", new Fight());
        registerCommand("look", new Look());
        registerCommand("info", new Info());
        registerCommand("take", new Take());


    }

    private void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    public void printAllCommands() {
        System.out.println("Available commands:");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.println(" - " + entry.getValue().getUsage());
        }
    }
}
