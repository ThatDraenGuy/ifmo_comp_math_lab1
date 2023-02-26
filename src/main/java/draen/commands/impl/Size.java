package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;

public class Size extends AbstractCommand {
    public Size() {
        super(new CommandData("size", 's', "Sets size of the matrix",
                ArgsType.INT, CommandType.BOTH));
    }

    @Override
    public ExecutionResult execute(CommandArgs args, CommonContext context) {
        if (args.getNumInt() < 2) return new ExecutionResult(false, "Invalid matrix size!");
        context.getConfig().setSize(args.getNumInt());
        return new ExecutionResult(true, "Matrix size set to " + args.getNumInt());
    }
}
