package draen.commands.impl.input;

import draen.commands.*;
import draen.data.context.CommonContext;
import draen.input.FileInputManager;

public class FileInput extends AbstractCommand {
    public FileInput() {
        super(new CommandData("file", 'f',
                "Configures matrix input to be read from specified file",
                ArgsType.FILE, CommandType.BOTH));
    }

    @Override
    public ExecutionResult execute(CommandArgs args, CommonContext context) {
        context.getConfig().setMatrixInputManager(new FileInputManager(args.getFile()));
        return new ExecutionResult(true, "Matrix input mode set to 'file' (" + args.getFile().getName() + ")");
    }
}
