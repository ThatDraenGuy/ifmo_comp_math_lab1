package draen.controllers;

import draen.data.context.ControllerContext;

public interface Controller {
    void handle(ControllerContext ctx);
}
