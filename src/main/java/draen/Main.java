package draen;

import draen.commands.impl.Auto;
import draen.commands.impl.Go;
import draen.controllers.*;
import draen.data.CommonContext;
import draen.commands.CommandsManager;
import draen.commands.CommandsStorage;
import draen.commands.impl.Help;
import draen.commands.impl.Size;
import draen.commands.impl.input.ConsoleInput;
import draen.commands.impl.input.FileInput;
import draen.commands.impl.input.RandomInput;
import draen.data.ControllerContext;
import draen.data.Config;
import draen.data.Progress;
import draen.input.ConsoleManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommandsStorage commandsStorage = new CommandsStorage();
        commandsStorage.addCommands(
                new Help(),
                new Size(),
                new Auto(),
                new Go(),
                new ConsoleInput(),
                new FileInput(),
                new RandomInput()
        );

        CommonContext context = new CommonContext(
                commandsStorage,
                new ConsoleManager(),
                new Config(),
                new Progress(),
                args
        );

        CommandsManager commandsManager = new CommandsManager(context);

        ControllerContext controllerContext = new ControllerContext(
                context, commandsManager
        );

        ControllerChain controllerChain = new ControllerChain(controllerContext, List.of(
                new GreetingsController(),
                new OptionsController(),
                new InteractionController(),
                new CalculationController()
        ));

        controllerChain.doNext();
    }
}
