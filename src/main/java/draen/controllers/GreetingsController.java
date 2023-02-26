package draen.controllers;

import draen.data.context.ControllerContext;

public class GreetingsController implements Controller {
    @Override
    public void handle(ControllerContext ctx) {
        ctx.getCommon().getIoManager().println(
                """
                          __  __       _        _         _____       _                            \s
                         |  \\/  |     | |      (_)       / ____|     | |                           \s
                         | \\  / | __ _| |_ _ __ ___  __ | (___   ___ | |_   _____ _ __             \s
                         | |\\/| |/ _` | __| '__| \\ \\/ /  \\___ \\ / _ \\| \\ \\ / / _ \\ '__|            \s
                         | |  | | (_| | |_| |  | |>  <   ____) | (_) | |\\ V /  __/ |               \s
                         |_|_ |_|\\__,_|\\__|_|  |_/_/\\_\\ |_____/ \\___/|_| \\_/_\\___|_|____        __ \s
                          / /             | |                              |__   __|  _ \\   /\\  \\ \\\s
                         | |_ __ ___  __ _| |  _ __   __ _ _ __ ___   ___     | |  | |_) | /  \\  | |
                         | | '__/ _ \\/ _` | | | '_ \\ / _` | '_ ` _ \\ / _ \\    | |  |  _ < / /\\ \\ | |
                         | | | |  __/ (_| | | | | | | (_| | | | | | |  __/    | |  | |_) / ____ \\| |
                         | |_|  \\___|\\__,_|_| |_| |_|\\__,_|_| |_| |_|\\___|    |_|  |____/_/    \\_\\ |
                          \\_\\                                                                   /_/\s
                                                                                                   \s
                                    created by ThatDraenGuy
                        """
        );
    }
}
