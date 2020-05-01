package by.it.example.helpers;

import by.it.example.beans.Weather;
import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureExtractorTest {

    @Test
    public void getCelsius() {
        Weather weather = new Weather(270.15);
        double expected = -3;
        double actual = TemperatureExtractor.getCelsius(weather);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void getKelvins() {
        Weather weather = new Weather(270.15);
        double expected = 270.15;
        double actual = TemperatureExtractor.getKelvins(weather);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void getFahrenheit() {
        Weather weather = new Weather(270.15);
        double expected = 26.6;
        double actual = TemperatureExtractor.getFahrenheit(weather);
        assertEquals(expected, actual, 1e-10);
    }
}