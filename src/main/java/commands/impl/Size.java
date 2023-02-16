package commands.impl;

import commands.*;

public class Size extends AbstractCommand {
    public Size() {
        super(new CommandData("size", 's', "Sets size of the matrix", ArgsType.NUM));
    }

    @Override
    public void execute(CommandArgs args, CommandContext context) {
        context.getConfig().setSize(args.getNum());
    }
}
