package draen.data;

import draen.commands.CommandsStorage;
import draen.input.IOManager;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonContext {
    private final CommandsStorage commandsStorage;
    private final IOManager ioManager;
    private final Config config;
    private final Progress progress;
    private final String[] args;
}
