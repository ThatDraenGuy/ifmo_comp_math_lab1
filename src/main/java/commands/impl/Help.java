package commands.impl;

import commands.*;

public class Help extends AbstractCommand {
    public Help() {
        super(new CommandData("help", 'h', "Displays all commands and their descriptions",
                ArgsType.NONE));
    }

    @Override
    public void execute(CommandArgs args, CommandContext context) {
        context.getCommandsStorage().getCommands().forEach(
                cmd -> context.getIoManager().display(displayCmd(cmd))
        );
    }

    private String displayCmd(Command cmd) {
        CommandData data = cmd.getData();
        return data.getName() +
                " (-" + data.getKey() + ")" +
                data.getArgsType().display() + ": " +
                data.getDescription() + "\n";
    }
}
