package draen;

import draen.controllers.ControllerChain;
import draen.controllers.GreetingsController;
import draen.controllers.OptionsController;
import draen.data.CommonContext;
import draen.commands.CommandsManager;
import draen.commands.CommandsStorage;
import draen.commands.impl.Help;
import draen.commands.impl.Size;
import draen.commands.impl.input.ConsoleInput;
import draen.commands.impl.input.FileInput;
import draen.commands.impl.input.RandomInput;
import draen.data.ControllerContext;
import draen.input.Config;
import draen.input.ConsoleManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CommandsStorage commandsStorage = new CommandsStorage();
        commandsStorage.addCommands(
                new Help(),
                new Size(),
                new ConsoleInput(),
                new FileInput(),
                new RandomInput()
        );

        CommonContext context = new CommonContext(
                commandsStorage,
                new ConsoleManager(),
                new Config(),
                args
        );

        CommandsManager commandsManager = new CommandsManager(context);

        ControllerContext controllerContext = new ControllerContext(
                context, commandsManager
        );

        ControllerChain controllerChain = new ControllerChain(controllerContext, List.of(
                new GreetingsController(),
                new OptionsController()
        ));

        controllerChain.doNext();
    }
}
