package draen.commands.impl;

import draen.commands.AbstractCommand;
import draen.commands.ArgsType;
import draen.commands.CommandArgs;
import draen.commands.CommandData;
import draen.data.CommonContext;

public class Size extends AbstractCommand {
    public Size() {
        super(new CommandData("size", 's', "Sets size of the matrix", ArgsType.NUM));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setSize(args.getNum());
    }
}
