package draen.data.context;

import draen.commands.CommandsManager;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ControllerContext {
    private final CommonContext common;
    private final CommandsManager commandsManager;
}
