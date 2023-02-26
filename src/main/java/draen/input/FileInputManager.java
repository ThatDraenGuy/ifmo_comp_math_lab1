package draen.input;

import draen.data.application.Config;
import draen.data.transfer.Equation;
import draen.exceptions.EquationInputException;
import draen.math.Matrix;
import lombok.AllArgsConstructor;

import java.io.*;
import java.util.Iterator;

@AllArgsConstructor
public class FileInputManager implements MatrixInputManager {
    private final File source;

    @Override
    public String getName() {
        return "file";
    }

    @Override
    public Equation readEquation(Config config) throws EquationInputException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
            String sizeString = reader.readLine();
            int size = Integer.parseInt(sizeString);
            config.setSize(size);
            return parseMatrices(size, reader.lines().iterator());
        } catch (IOException e) {
            throw new EquationInputException(
                    "Problems encountered when working with file '" + source.getName() + "'"
            );
        } catch (NumberFormatException e) {
            throw new EquationInputException(
                    "Problems encountered when parsing matrices from file '" + source.getName() + "'"
            );
        }
    }

    private Equation parseMatrices(int size, Iterator<String> source)
            throws EquationInputException, NumberFormatException {

        double[][] base = new double[size][size];
        double[][] result = new double[size][1];

        int currentY = 0;
        while (source.hasNext()) {
            String line = source.next();
            String[] elements = line.split("\\s+");
            if (elements.length != size + 1)
                throw new EquationInputException(
                        "Incorrect number of elements in row! Expected: " + (size+1) + "; got: " + elements.length);
            for (int i = 0; i < size; i++) {
                base[currentY][i] = Double.parseDouble(elements[i]);
            }
            result[currentY][0] = Double.parseDouble(elements[size]);
            currentY++;
        }
        if (currentY != size) throw new EquationInputException("Incorrect number of rows in matrix!");
        return new Equation(new Matrix(base), new Matrix(result));
    }
}
