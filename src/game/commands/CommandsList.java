package game.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandsList {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandsList() {
        registerCommand("walk", new Walk());

    }

    private void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    public void printAllCommands() {
        System.out.println("Dostupné příkazy:");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.println(" - " + entry.getValue().getUsage());
        }
    }
}
