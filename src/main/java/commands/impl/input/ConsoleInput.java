package commands.impl.input;

import commands.*;

public class ConsoleInput extends AbstractCommand {
    public ConsoleInput() {
        super(new CommandData("console", 'c',
                "Configures matrix input to be read form manual input", ArgsType.NONE));
    }

    @Override
    public void execute(CommandArgs args, CommandContext context) {
        context.getConfig().setMatrixInputManager(context.getIoManager());
    }
}
