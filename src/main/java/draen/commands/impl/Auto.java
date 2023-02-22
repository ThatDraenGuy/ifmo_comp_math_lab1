package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;

public class Auto extends AbstractCommand {
    public Auto() {
        super(new CommandData("auto", 'a',
                "Skips interaction mode and goes straight for calculation",
                ArgsType.NONE, CommandType.OPTION_ONLY));
    }

    @Override
    public ExecutionResult execute(CommandArgs args, CommonContext context) {
        context.getProgress().setAuto(true);
        return new ExecutionResult(true, "Starting calculation...");
    }
}
