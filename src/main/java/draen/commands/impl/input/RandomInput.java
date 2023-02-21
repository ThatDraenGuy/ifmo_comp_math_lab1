package draen.commands.impl.input;

import draen.commands.*;
import draen.data.context.CommonContext;
import draen.input.RandomInputManager;

public class RandomInput extends AbstractCommand {
    public RandomInput() {
        super(new CommandData("random", 'r',
                "Configures matrix input as random with range specified",
                ArgsType.RANGE, CommandType.BOTH));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(new RandomInputManager(args.getRange()));
    }
}
