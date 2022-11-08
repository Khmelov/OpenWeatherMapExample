package by.it.example.helpers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureFormatterTest {

    @Test
    public void humanizeStringMeasure() {
        String expected = "+2°C";
        String actual = TemperatureFormatter.humanize(2, "°C");
        assertEquals(expected, actual,"Incorrect TemperatureFormatter");
    }

    @Test
    public void humanizeCharMeasure() {
        String expected = "+2°C";
        String actual = TemperatureFormatter.humanize(2, 'C');
        assertEquals(expected, actual, "Incorrect TemperatureFormatter");
    }
}