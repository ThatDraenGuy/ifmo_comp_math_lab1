package math;

import exceptions.AlgebraException;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class Matrix {
    private final double[][] data;

    public Matrix(int width, int height) {
        data = new double[height][width];
    }

    public int height() {
        return data.length;
    }

    public int width() {
        return data[0].length;
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
        forAll((i, j) -> res.data[i][j] = mulElem(other, i, j));
        return res;
    }

    private double mulElem(Matrix other, int y, int x) {
        return IntStream.range(0, width())
                .mapToDouble(i -> this.data[y][i] * other.data[i][x])
                .sum();
    }

    private void forAll(BiConsumer<Integer, Integer> action) {
        for (int i = 0; i < this.height(); i++) {
            for (int j = 0; j < this.width(); j++) {
                action.accept(i, j);
            }
        }
    }
}
