package draen.controllers;

import draen.data.context.ControllerContext;
import draen.input.IOManager;

public class FarewellController implements Controller {
    @Override
    public void handle(ControllerContext ctx) {
        IOManager ioManager = ctx.getCommon().getIoManager();
        ioManager.println("Program finished working, exiting...");
    }
}
