package draen.controllers;

import draen.data.context.ControllerContext;

import java.util.*;

public class ControllerChain {
    private final ControllerContext context;
    private final Queue<Controller> controllers;

    public ControllerChain(ControllerContext context, List<Controller> controllers) {
        this.context = context;
        this.controllers = new LinkedList<>(controllers);
    }

    public void begin() {
        while (!controllers.isEmpty()) {
            controllers.remove().handle(context);
        }
    }
}
