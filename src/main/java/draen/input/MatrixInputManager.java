package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Equation;
import draen.exceptions.EquationInputException;

public interface MatrixInputManager {
    String getName();
    Equation readEquation(Config config) throws EquationInputException;
}
