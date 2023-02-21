package draen.controllers;

import draen.commands.CommandArgs;
import draen.commands.CommandData;
import draen.commands.CommandRequest;
import draen.data.context.ControllerContext;
import draen.data.application.Progress;
import draen.exceptions.ArgsParseException;
import draen.exceptions.ArgsTypeException;
import draen.exceptions.OptionsException;
import draen.input.IOManager;

import java.util.Arrays;
import java.util.Iterator;

public class InteractionController implements Controller {
    @Override
    public void handle(ControllerContext ctx) {
        Progress progress = ctx.getCommon().getProgress();
        IOManager ioManager = ctx.getCommon().getIoManager();

        if (progress.isAuto()) return;
        ioManager.println(
                """
                        Welcome to Matrix Solver (real name TBA)!
                        You are currently in the interaction mode.
                        Type 'help' to see your options.
                        Type 'go' to begin calculation.
                        Current configuration:
                        """
        );
        ioManager.println(ctx.getCommon().getConfig().display());

        while (! ctx.getCommon().getProgress().isStart()) {
            try {
                String input = ioManager.readLine();
                CommandRequest request = parseInput(ctx, input);
                ctx.getCommandsManager().execute(request);
            } catch (ArgsParseException | OptionsException | ArgsTypeException e) {
                ioManager.println(e.getMessage());
            }

        }
    }


    private CommandRequest parseInput(ControllerContext ctx, String input) throws OptionsException, ArgsParseException {
        String[] strings = input.split(" ");
        String name = strings[0];

        CommandData data = ctx.getCommon().getCommandsStorage().getDataByName(name);
        if (data == null) throw new OptionsException("Unknown command!");

        Iterator<String> iterator = Arrays.stream(strings).skip(1).iterator();
        CommandArgs args = CommandArgs.parseArgs(iterator, data.getArgsType());
        return new CommandRequest(name, args);
    }
}
