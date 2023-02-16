package commands.impl.input;

import commands.*;
import input.FileInputManager;

public class FileInput extends AbstractCommand {
    public FileInput() {
        super(new CommandData("file", 'f',
                "Configures matrix input to be read from specified file", ArgsType.FILE));
    }

    @Override
    public void execute(CommandArgs args, CommandContext context) {
        context.getConfig().setMatrixInputManager(new FileInputManager(args.getFile()));
    }
}
