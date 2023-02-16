package draen.controllers;

import draen.commands.CommandArgs;
import draen.commands.CommandData;
import draen.commands.CommandRequest;
import draen.data.CommonContext;
import draen.data.ControllerContext;
import draen.exceptions.OptionsException;

import java.util.Arrays;
import java.util.Iterator;

public class OptionsController implements Controller {
    @Override
    public void handle(ControllerContext ctx, ControllerChain chain) {
        Iterator<String> iterator = Arrays.stream(ctx.getCommon().getArgs()).iterator();
        try {
            while (iterator.hasNext()) {
                CommandData data = parseOption(ctx.getCommon(), iterator.next());
                CommandArgs args = CommandArgs.parseArgs(iterator, data.getArgsType());
                ctx.getCommandsManager().execute(new CommandRequest(data.getName(), args));
            }
        } catch (Exception e) {
            ctx.getCommon().getIoManager().display(
                    "Error encountered while parsing application options: \n" +
                            e.getMessage() +
                            "\nProceed with caution - not all entered options were correctly handled."
            );
        }

        chain.doNext();
    }




    private CommandData parseOption(CommonContext ctx, String option) throws OptionsException {
        if (option.startsWith("--")) {
            String name = option.substring(2);
            return ctx.getCommandsStorage().getByName(name).getData();
        }
        if (option.startsWith("-")) {
            char key = option.charAt(1);
            return ctx.getCommandsStorage().getByKey(key).getData();
        }
        throw new OptionsException("Invalid parameter encountered: " + option);
    }
}
