package draen.data.transfer;

import draen.math.Matrix;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Solution {
    private final Matrix result;
    private final long stepAmount;
    private final Matrix error;

    public String display() {
        return "Solution: \n" +
                "- number of iterations: " + stepAmount +"\n" +
                "- X: \n" + result.display() +
                "- error: \n" + error.display();
    }
}
