package draen.commands.impl.input;

import draen.commands.AbstractCommand;
import draen.commands.ArgsType;
import draen.commands.CommandArgs;
import draen.commands.CommandData;
import draen.data.CommonContext;
import draen.input.FileInputManager;

public class FileInput extends AbstractCommand {
    public FileInput() {
        super(new CommandData("file", 'f',
                "Configures matrix draen.input to be read from specified file", ArgsType.FILE));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(new FileInputManager(args.getFile()));
    }
}
