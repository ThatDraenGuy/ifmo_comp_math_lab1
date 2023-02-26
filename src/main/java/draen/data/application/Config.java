package draen.data.application;

import draen.data.transfer.Range;
import draen.input.MatrixInputManager;
import draen.input.RandomInputManager;
import draen.math.IterationAlgorithm;
import draen.math.SimpleIterationAlgorithm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
    public final static int DEFAULT_SIZE = 5;
    public final static double DEFAULT_PRECISION = 0.1;
    public final static MatrixInputManager DEFAULT_INPUT = new RandomInputManager(new Range(1,10));
    public final static IterationAlgorithm DEFAULT_ALGORITHM = new SimpleIterationAlgorithm();

    private int size = DEFAULT_SIZE;
    private double precision = DEFAULT_PRECISION;
    private MatrixInputManager matrixInputManager = DEFAULT_INPUT;
    private IterationAlgorithm iterationAlgorithm = DEFAULT_ALGORITHM;


    public String display() {
        return
                "Matrix size: " + size + ";\n"
                + "Precision: " + precision + ";\n"
                + "Matrix input mode: " + matrixInputManager.getName();
    }
}
