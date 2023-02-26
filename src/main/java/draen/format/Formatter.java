package draen.format;

import java.text.DecimalFormat;

public class Formatter {
    private final static DecimalFormat decimalFormat = new DecimalFormat("0.###");

    public static String format(double num) {
        return decimalFormat.format(num);
    }
}
