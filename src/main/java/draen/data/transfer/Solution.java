package draen.data.transfer;

import draen.math.Matrix;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;

@Getter
@AllArgsConstructor
public class Solution {
    private final Matrix result;
    private final Matrix error;
    private final long stepAmount;
    private final Duration duration;

    public String display() {
        return "Solution: \n" +
                "- duration: " + duration.toNanos() / 1000 +"μs\n" +
                "- number of iterations: " + stepAmount +"\n" +
                "- X: \n" + result.displayExact() +
                "- error: \n" + error.displayExact();
    }
}
