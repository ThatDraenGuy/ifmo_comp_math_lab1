package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Range;
import draen.data.transfer.Equation;
import draen.math.Matrix;
import lombok.AllArgsConstructor;

import java.util.Arrays;

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
        Matrix a = new Matrix(getBaseMatrix(size));
        Matrix b = new Matrix(1, size, this::getNum);
        return new Equation(a, b);
    }

    private double[][] getBaseMatrix(int size) {
        double[][] data = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) data[i][j] = getNum(i, j);
            }
            data[i][i] = Arrays.stream(data[i]).map(Math::abs).sum() + Math.abs(getNum(i, i));
        }
        return data;
    }

    private double getNum(int i, int j) {
        return Math.random() * (range.getMax() - range.getMin() ) + range.getMin();
    }
}
