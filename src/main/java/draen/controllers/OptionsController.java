package draen.controllers;

import draen.commands.CommandArgs;
import draen.commands.CommandData;
import draen.commands.CommandRequest;
import draen.data.context.CommonContext;
import draen.data.context.ControllerContext;
import draen.exceptions.OptionsException;

import java.util.Arrays;
import java.util.Iterator;

public class OptionsController implements Controller {
    @Override
    public void handle(ControllerContext ctx) {
        Iterator<String> iterator = Arrays.stream(ctx.getCommon().getArgs()).iterator();
        try {
            while (iterator.hasNext()) {
                CommandData data = parseOption(ctx.getCommon(), iterator.next());
                if (data==null) throw new OptionsException("Unknown option encountered");
                CommandArgs args = CommandArgs.parseArgs(iterator, data.getArgsType());
                ctx.getCommandsManager().execute(new CommandRequest(data.getName(), args));
            }
        } catch (Exception e) {
            ctx.getCommon().getIoManager().println(
                    "Error encountered while parsing application options: \n" +
                            e.getMessage() +
                            "\nProceed with caution - not all entered options were correctly handled."
            );
        }
    }




    private CommandData parseOption(CommonContext ctx, String option) throws OptionsException {
        if (option.startsWith("--")) {
            String name = option.substring(2);
            return ctx.getCommandsStorage().getDataByName(name);
        }
        if (option.startsWith("-")) {
            char key = option.charAt(1);
            return ctx.getCommandsStorage().getDataByKey(key);
        }
        throw new OptionsException("Invalid parameter encountered: " + option);
    }
}
