package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Range;
import draen.data.transfer.Equation;
import draen.math.Matrix;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RandomInputManager implements MatrixInputManager {
    private final Range range;

    @Override
    public String getName() {
        return "random";
    }

    @Override
    public Equation readEquation(Config config) {
        int size = config.getSize();
        Matrix a = new Matrix(size, size, this::getNum);
        Matrix b = new Matrix(1, size, this::getNum);
        return new Equation(a, b);
    }

    private double getNum(int i, int j) {
        return Math.random() * (range.getMax() - range.getMin() ) + range.getMin();
    }
}
