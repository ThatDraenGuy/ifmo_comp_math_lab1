package draen.commands;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CommandsStorage {
    private final Map<String, Command> commandsByName;
    private final Map<Character, Command> commandsByKey;

    public CommandsStorage() {
        commandsByName = new HashMap<>();
        commandsByKey = new HashMap<>();
    }

    public void addCommands(Command... commands) {
        for (Command command : commands) {
            this.commandsByName.put(command.getData().getName(), command);
            this.commandsByKey.put(command.getData().getKey(), command);
        }
    }

    public Command getByName(String name) {
        return commandsByName.get(name);
    }
    public Command getByKey(char key) {
        return commandsByKey.get(key);
    }

    public Collection<Command> getCommands() {
        return commandsByName.values();
    }
}
