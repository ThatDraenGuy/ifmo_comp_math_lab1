package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;

public class Precision extends AbstractCommand {
    public Precision() {
        super(new CommandData("precision", 'p', "Sets desired precision",
                ArgsType.INT, CommandType.BOTH));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setPrecision(args.getNumDouble());
    }
}
