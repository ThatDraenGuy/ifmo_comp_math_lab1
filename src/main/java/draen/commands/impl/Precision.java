package draen.commands.impl;

import draen.commands.*;
import draen.data.context.CommonContext;
import draen.format.Formatter;

public class Precision extends AbstractCommand {
    public Precision() {
        super(new CommandData("precision", 'p', "Sets desired precision",
                ArgsType.DOUBLE, CommandType.BOTH));
    }

    @Override
    public ExecutionResult execute(CommandArgs args, CommonContext context) {
        Formatter.setPrecision(args.getNumDouble());
        context.getConfig().setPrecision(args.getNumDouble());
        return new ExecutionResult(true, "Precision set to " + Formatter.formatWithPrecision(args.getNumDouble()));
    }
}
