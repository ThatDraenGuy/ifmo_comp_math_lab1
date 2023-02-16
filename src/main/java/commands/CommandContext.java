package commands;

import input.Config;
import input.IOManager;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommandContext {
    private final CommandsStorage commandsStorage;
    private final IOManager ioManager;
    private final Config config;
}
