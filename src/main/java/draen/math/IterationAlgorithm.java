package draen.math;

import draen.data.transfer.Equation;
import draen.data.transfer.Solution;
import draen.exceptions.AlgebraException;

public interface IterationAlgorithm {
    Solution solve(Equation equation, double precision) throws AlgebraException;
}
