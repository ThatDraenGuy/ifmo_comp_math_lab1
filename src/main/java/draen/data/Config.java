package draen.data;

import draen.input.MatrixInputManager;
import draen.input.RandomInputManager;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config {
    public final static int DEFAULT_SIZE = 5;
    public final static MatrixInputManager DEFAULT_INPUT = new RandomInputManager(new Range(1,10));

    private int size = DEFAULT_SIZE;
    private MatrixInputManager matrixInputManager = DEFAULT_INPUT;


    public String display() {
        return
                "Matrix size: " + size + ";\n"
                + "Matrix input mode: " + matrixInputManager.getName() + ";\n";
    }
}
