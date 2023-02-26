package draen;

import draen.commands.impl.*;
import draen.controllers.*;
import draen.data.context.CommonContext;
import draen.commands.CommandsManager;
import draen.commands.CommandsStorage;
import draen.commands.impl.input.ConsoleInput;
import draen.commands.impl.input.FileInput;
import draen.commands.impl.input.RandomInput;
import draen.data.context.ControllerContext;
import draen.data.application.Config;
import draen.data.application.Progress;
import draen.input.ConsoleManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommandsStorage commandsStorage = new CommandsStorage();
        commandsStorage.addCommands(
                new Help(),
                new Size(),
                new Precision(),
                new DisplayConfig(),
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
                new CalculationController(),
                new FarewellController()
        ));

        controllerChain.begin();
    }
}
