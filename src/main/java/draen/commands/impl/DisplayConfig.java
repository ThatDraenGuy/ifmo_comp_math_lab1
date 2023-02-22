package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;

public class DisplayConfig extends AbstractCommand {
    public DisplayConfig() {
        super(new CommandData("config", 'C', "Displays current config",
                ArgsType.NONE, CommandType.INTERACT_ONLY));
    }

    @Override
    public ExecutionResult execute(CommandArgs args, CommonContext context) {
        context.getIoManager().println(context.getConfig().display());
        return new ExecutionResult(true, "Config displayed");
    }
}
