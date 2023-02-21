package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Equation;
import draen.format.Formatter;
import draen.math.Matrix;



public class ConsoleInputManager extends ConsoleManager implements MatrixInputManager {
    private String[][] current;
    @Override
    public String getName() {
        return "console";
    }

    @Override
    public Equation readEquation(Config config) {
        int size = config.getSize();
        println("Enter matrix A:");
        createMockupMatrix(size, size);
        Matrix a = new Matrix(size, size, this::getNum);
        println("Enter matrix B:");
        createMockupMatrix(size, 1);
        Matrix b = new Matrix(1, size, this::getNum);
        return new Equation(a, b);
    }

    private double getNum(int currentY, int currentX) {
        while (true) {
            current[currentY][currentX] = "^\t";

            println("Enter element at ("+ currentY + ", " + currentX+"): ");
            displayCurrentMatrix();

            String input = readLine();
            try {
                double val = Double.parseDouble(input);
                current[currentY][currentX] = Formatter.format(val) + "\t";
                return val;
            } catch (NumberFormatException e) {
                displayError("Couldn't parse double from '" + input +"'. Please try again:");
            }
        }
    }

    private void displayCurrentMatrix() {
        for (String[] row : current) {
            for (String value : row) {
                print(value);
            }
            println("");
        }
    }

    private void createMockupMatrix(int y, int x) {
        current = new String[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                current[i][j] = "-\t";
            }
        }
    }
}
