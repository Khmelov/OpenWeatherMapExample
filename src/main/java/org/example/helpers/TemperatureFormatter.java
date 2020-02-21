package org.example.helpers;

public class TemperatureFormatter {

    public static String humanize(double value, char measure) {
        char sign = value < 0 ? '-' : '+';
        long showValue = Math.round(value);
        return String.format("%s%d°%s", sign, showValue, measure);
    }
}
