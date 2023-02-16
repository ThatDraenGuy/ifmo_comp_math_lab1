package math;

import exceptions.AlgebraException;


public class SimpleIterationAlgorithm {


    private Matrix iter(Matrix a, Matrix b, Matrix x) throws AlgebraException {
        return a.mul(x).add(b);
    }
}
