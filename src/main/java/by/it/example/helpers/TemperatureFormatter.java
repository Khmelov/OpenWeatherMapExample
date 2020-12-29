package by.it.example.helpers;

public class TemperatureFormatter {

    private TemperatureFormatter() {
    }

    public static String humanize(double value, String measure) {
        char sign = value < 0 ? '-' : '+';
        long showValue = Math.abs(Math.round(value));
        return String.format("%s%d%s", sign, showValue, measure);
    }

    public static String humanize(double value, char measure) {
        char sign = value < 0 ? '-' : '+';
        long showValue = Math.abs(Math.round(value));
        return String.format("%s%d°%s", sign, showValue, measure);
    }
}
