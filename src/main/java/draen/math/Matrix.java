package draen.math;

import draen.data.transfer.Equation;
import draen.exceptions.AlgebraException;
import draen.format.Formatter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Math.abs;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix {
    private final double[][] data;

    public Matrix(int width, int height) {
        data = new double[height][width];
    }

    public Matrix(int width, int height, double value) {
        data = new double[height][width];
        forAll((i, j) -> data[i][j] = value);
    }

    public Matrix(int width, int height, BiFunction<Integer, Integer, Double> value) {
        data = new double[height][width];
        forAll((i, j) -> data[i][j] = value.apply(i, j));
    }

    public int height() {
        return data.length;
    }

    public int width() {
        return data[0].length;
    }

    public boolean isDiagonalDominating() {
        for (int i = 0; i < this.height(); i++) {
            double sum = 0;
            for (int j = 0; j < this.width(); j++) {
                if (j!=i) sum += data[i][j];
            }
            if (sum > data[i][i]) return false;
        }
        return true;
    }

    public String display() {
        StringBuilder builder = new StringBuilder();
        forEachRow().forEach(row -> {
            for (double val : row) {
                builder.append(Formatter.format(val)).append(' ');
            }
            builder.append('\n');
        });
        return builder.toString();
    }

    public Matrix getCopy() {
        Matrix copy = new Matrix(width(), height());
        forAll((i, j) -> copy.data[i][j] = this.data[i][j]);
        return copy;
    }

    public double norm() {
        double maxSum = 0;
        for (int i = 0; i < height(); i++) {
            double sum = absRowSum(i);
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }

    public Matrix add(Matrix other) throws AlgebraException {
        if (this.height() != other.height() || this.width() != other.width()) {
            throw new AlgebraException("Size mismatch");
        }
        Matrix res = new Matrix(width(), height());
        forAll((i, j) -> res.data[i][j] = this.data[i][j] + other.data[i][j]);
        return res;
    }

    public Matrix mul(Matrix other) throws AlgebraException {
        if (this.width() != other.height()) throw new AlgebraException("Size mismatch!");
        Matrix res = new Matrix(other.width(), height());
        res.forAll((i, j) -> res.data[i][j] = mulElem(other, i, j));
        return res;
    }

    private double mulElem(Matrix other, int y, int x) {
        return IntStream.range(0, width())
                .mapToDouble(i -> this.data[y][i] * other.data[i][x])
                .sum();
    }

    private double absRowSum(int rowIndex) {
        return Arrays.stream(data[rowIndex], 0, width()).map(Math::abs)
                .sum();
    }

    private Stream<double[]> forEachRow() {
        return Arrays.stream(data, 0, height());
    }

    private void forAll(BiConsumer<Integer, Integer> action) {
        for (int i = 0; i < this.height(); i++) {
            for (int j = 0; j < this.width(); j++) {
                action.accept(i, j);
            }
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Extended {
        private final Matrix base;
        private final Matrix result;

        public static Extended fromEquation(Equation equation) {
            return new Extended(equation.getA(), equation.getB());
        }


        public Extended getWithDiagonalDominating() throws AlgebraException {
            int[] rowMappings = new int[base.width()];
            Arrays.fill(rowMappings, -1);

            for (int i = 0; i < base.height(); i++) {
                double sum = base.absRowSum(i);
                double[] row = base.data[i];
                for (int j = 0; j < base.width(); j++) {
                    if (abs(2 * row[j]) >= sum) {
                        if (rowMappings[j] != -1)
                            throw new AlgebraException("Impossible to achieve diagonal domination!");
                        rowMappings[j] = i;
                        break;
                    }
                }
            }

            Matrix newBase = new Matrix(base.width(), base.height());
            Matrix newResult = new Matrix(result.width(), result.height());
            for (int rowPos = 0; rowPos < rowMappings.length; rowPos++) {
                if (rowMappings[rowPos]==-1) throw new AlgebraException("Impossible to achieve diagonal domination!");
                newBase.data[rowPos] = base.data[rowMappings[rowPos]];
                newResult.data[rowPos] = newResult.data[rowMappings[rowPos]];
            }
            return new Extended(newBase, newResult);
        }

        public Extended forIteration() {
            Matrix newBase = new Matrix(base.width(), base.height());
            Matrix newResult = new Matrix(result.width(), result.height());

            base.forAll((i, j) -> {
                if (Objects.equals(i, j))  newBase.data[i][j] = 0;
                else newBase.data[i][j] = -1 * base.data[i][j] / base.data[i][i];
            });

            result.forAll((i, j) ->
                    newResult.data[i][j] = result.data[i][j] / base.data[i][i]
            );

            return new Extended(newBase, newResult);
        }
    }
}