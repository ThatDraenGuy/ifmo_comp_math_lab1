package draen.commands.impl;

import draen.commands.*;
import draen.data.CommonContext;

public class Size extends AbstractCommand {
    public Size() {
        super(new CommandData("size", 's', "Sets size of the matrix",
                ArgsType.NUM, CommandType.BOTH));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setSize(args.getNum());
    }
}
