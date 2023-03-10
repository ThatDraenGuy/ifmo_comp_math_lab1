package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;

public class Go extends AbstractCommand {
    public Go() {
        super(new CommandData("go", 'g', "Starts calculation",
                ArgsType.NONE, CommandType.INTERACT_ONLY));
    }

    @Override
    public ExecutionResult execute(CommandArgs args, CommonContext context) {
        context.getProgress().setStart(true);
        return new ExecutionResult(true, "Starting calculation...");
    }
}
