package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Equation;

public interface MatrixInputManager {
    String getName();
    Equation readEquation(Config config);
}
