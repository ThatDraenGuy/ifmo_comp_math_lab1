package draen.commands.impl.input;

import draen.commands.*;
import draen.data.context.CommonContext;
import draen.input.ConsoleInputManager;

public class ConsoleInput extends AbstractCommand {
    public ConsoleInput() {
        super(new CommandData("console", 'c',
                "Configures matrix input to be read from manual input",
                ArgsType.NONE, CommandType.BOTH));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(new ConsoleInputManager());
    }
}
