package draen.math;

import draen.data.transfer.Equation;
import draen.data.transfer.Solution;
import draen.exceptions.AlgebraException;


public class SimpleIterationAlgorithm implements IterationAlgorithm {
    public static long MAX_STEP_AMOUNT = 1000;

    private Matrix iter(Matrix a, Matrix b, Matrix x) throws AlgebraException {
        return a.mul(x).add(b);
    }

    @Override
    public Solution solve(Equation equation, double precision) throws AlgebraException {
        Matrix.Extended extendedMatrix = Matrix.Extended.fromEquation(equation);

        if (! extendedMatrix.getBase().isDiagonalDominating()) {
            extendedMatrix = extendedMatrix.getWithDiagonalDominating();
        }

        extendedMatrix = extendedMatrix.forIteration();
        Matrix a = extendedMatrix.getBase();
        Matrix b = extendedMatrix.getResult();
        Matrix x = b.getCopy();

        long stepAmount = getStepAmount(precision, a, b, x);
        if (stepAmount > MAX_STEP_AMOUNT) throw new AlgebraException("Cannot handle such precision");
        double actualPrecision = getActualPrecision(stepAmount, a, b, x);
        for (long i = 0; i < stepAmount; i++) {
            x = iter(a, b, x);
        }
        return new Solution(x, stepAmount, new Matrix(x.width(), x.height(), actualPrecision));
    }

    private long getStepAmount(double precision, Matrix a, Matrix b, Matrix x) {
        double normA = a.norm();
        double normB = b.norm();
        double normX = x.norm();

        double k = Math.log(precision / ( normX + normB / ( 1 - normA ) ) ) / Math.log(normA);
        return Math.round(k) + 1;
    }

    private double getActualPrecision(long stepAmount, Matrix a, Matrix b, Matrix x) {
        double normA = a.norm();
        double normB = b.norm();
        double normX = x.norm();

        return Math.pow(normA, stepAmount) * ( normX + normB / ( 1 - normA ) );
    }
}
