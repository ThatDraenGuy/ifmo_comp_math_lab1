package commands.impl.input;

import commands.*;
import input.RandomInputManager;

public class RandomInput extends AbstractCommand {
    public RandomInput() {
        super(new CommandData("random", 'r',
                "Configures matrix input as random with range specified", ArgsType.RANGE));
    }

    @Override
    public void execute(CommandArgs args, CommandContext context) {
        context.getConfig().setMatrixInputManager(new RandomInputManager(args.getRange()));
    }
}
