package draen.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Formatter {
    private final static DecimalFormat decimalFormat = new DecimalFormat("0.###");
    private static final DecimalFormat exactDecimalFormat = new DecimalFormat("0.##");

    public static String format(double num) {
        return decimalFormat.format(num);
    }
    public static String formatExact(double num) {
        return exactDecimalFormat.format(num);
    }


    public static void setPrecision(double precision) {
        if (precision <= 0.0000001) throw new IllegalArgumentException();
        if (precision >= 1) {
            exactDecimalFormat.applyPattern("0");
        } else {
            exactDecimalFormat.applyPattern("0." + "#".repeat(getDigitsNum(precision) + 1));
        }

    }

    private static int getDigitsNum(double num) {
        BigDecimal decimal = BigDecimal.valueOf(num);
        String text = decimal.toPlainString();
        String[] split = text.split("\\.");
        if (split.length > 1) return split[1].length();
        return 0;
    }
}
