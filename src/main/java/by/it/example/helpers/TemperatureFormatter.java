package by.it.example.helpers;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TemperatureFormatter {

    public String humanize(double value, String measure) {
        char sign = value < 0 ? '-' : '+';
        long showValue = Math.abs(Math.round(value));
        return String.format("%s%d%s", sign, showValue, measure);
    }

    public String humanize(double value, char measure) {
        char sign = value < 0 ? '-' : '+';
        long showValue = Math.abs(Math.round(value));
        return String.format("%s%d°%s", sign, showValue, measure);
    }
}
