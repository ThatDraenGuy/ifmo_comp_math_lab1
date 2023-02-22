package draen.commands;

import draen.data.context.CommonContext;

public interface Command {
    ExecutionResult execute(CommandArgs args, CommonContext context);
    CommandData getData();
}
