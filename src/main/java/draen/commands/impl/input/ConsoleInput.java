package draen.commands.impl.input;

import draen.data.CommonContext;
import draen.commands.AbstractCommand;
import draen.commands.ArgsType;
import draen.commands.CommandArgs;
import draen.commands.CommandData;

public class ConsoleInput extends AbstractCommand {
    public ConsoleInput() {
        super(new CommandData("console", 'c',
                "Configures matrix draen.input to be read form manual draen.input", ArgsType.NONE));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(context.getIoManager());
    }
}
