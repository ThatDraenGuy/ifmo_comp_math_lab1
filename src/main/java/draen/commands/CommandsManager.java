package draen.commands;

import draen.data.context.CommonContext;
import draen.exceptions.ArgsTypeException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandsManager {
    private final CommonContext context;


    public ExecutionResult execute(CommandRequest request) throws ArgsTypeException {
        Command command = context.getCommandsStorage().getByName(request.getName());
        if (! command.getData().getArgsType().equals(request.getArgs().getType())) {
            throw new ArgsTypeException("Args type mismatch");
        }
        return command.execute(request.getArgs(), context);
    }
}
