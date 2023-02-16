package commands;

import exceptions.ArgsTypeException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommandsManager {
    private final CommandContext context;


    public void execute(CommandRequest request) throws ArgsTypeException {
        Command command = context.getCommandsStorage().getByName(request.getName());
        if (! command.getData().getArgsType().equals(request.getArgs().getType())) {
            throw new ArgsTypeException("Args type mismatch");
        }
        command.execute(request.getArgs(), context);
    }
}