package draen.controllers;

import draen.data.application.Config;
import draen.data.context.ControllerContext;
import draen.data.transfer.Equation;
import draen.data.transfer.Solution;
import draen.exceptions.AlgebraException;
import draen.input.IOManager;

public class CalculationController implements Controller {
    @Override
    public void handle(ControllerContext ctx) {
        IOManager ioManager = ctx.getCommon().getIoManager();
        ioManager.println("Reading matrix...");
        Config config = ctx.getCommon().getConfig();
        Equation equation = config.getMatrixInputManager().readEquation(config);
        ioManager.println("Matrix read, calculating...");
        try {
            Solution solution = config.getIterationAlgorithm().solve(equation, config.getPrecision());
            ioManager.println(solution.display());
        } catch (AlgebraException e) {
            ioManager.displayError(e);
        }
    }
}
