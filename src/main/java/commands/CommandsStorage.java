package commands;

import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandsStorage {
    private final Map<String, Command> commands;

    public CommandsStorage() {
        commands = new HashMap<>();
    }

    public void addCommands(Command... commands) {
        for (Command command : commands) {
            this.commands.put(command.getData().getName(), command);
        }
    }

    public Command getByName(String name) {
        return commands.get(name);
    }

    public Collection<Command> getCommands() {
        return commands.values();
    }
}
