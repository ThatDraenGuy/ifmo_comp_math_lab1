package draen.commands;

import draen.data.context.CommonContext;

public interface Command {
    void execute(CommandArgs args, CommonContext context);
    CommandData getData();
}
