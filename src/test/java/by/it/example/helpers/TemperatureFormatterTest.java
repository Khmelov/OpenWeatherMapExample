package by.it.example.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureFormatterTest {

    @Test
    public void humanizeStringMeasure() {
        String expected = "+2°C";
        String actual = TemperatureFormatter.humanize(2, "°C");
        assertEquals("Incorrect TemperatureFormatter", expected, actual);
    }

    @Test
    public void humanizeCharMeasure() {
        String expected = "+2°C";
        String actual = TemperatureFormatter.humanize(2, 'C');
        assertEquals("Incorrect TemperatureFormatter", expected, actual);
    }
}