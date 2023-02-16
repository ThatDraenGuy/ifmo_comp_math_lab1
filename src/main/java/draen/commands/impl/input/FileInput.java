package draen.commands.impl.input;

import draen.commands.*;
import draen.data.CommonContext;
import draen.input.FileInputManager;

public class FileInput extends AbstractCommand {
    public FileInput() {
        super(new CommandData("file", 'f',
                "Configures matrix input to be read from specified file",
                ArgsType.FILE, CommandType.BOTH));
    }

    @Override
    public void execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(new FileInputManager(args.getFile()));
    }
}
