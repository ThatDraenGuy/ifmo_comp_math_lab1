package draen.commands.impl.input;

import draen.commands.AbstractCommand;
import draen.commands.ArgsType;
import draen.commands.CommandArgs;
import draen.commands.CommandData;
import draen.data.CommonContext;
import draen.input.RandomInputManager;

public class RandomInput extends AbstractCommand {
    public RandomInput() {
        super(new CommandData("random", 'r',
                "Configures matrix draen.input as random with range specified", ArgsType.RANGE));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(new RandomInputManager(args.getRange()));
    }
}
