package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;

public class Help extends AbstractCommand {
    public Help() {
        super(new CommandData("help", 'h', "Displays all commands and their descriptions",
                ArgsType.NONE, CommandType.BOTH));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getCommandsStorage().getCommands().forEach(
                cmd -> context.getIoManager().println(displayCmd(cmd))
        );
    }

    private String displayCmd(Command cmd) {
        CommandData data = cmd.getData();
        if (data.getCommandType().equals(CommandType.NONE)) return "";
        return data.getName() +
                " (-" + data.getKey() + ")" +
                data.getArgsType().display() +
                data.getCommandType().display() + ": " +
                data.getDescription() + "\n";
    }
}
