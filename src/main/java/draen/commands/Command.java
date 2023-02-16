package draen.commands;

import draen.data.CommonContext;

public interface Command {
    void execute(CommandArgs args, CommonContext context);
    CommandData getData();
}
