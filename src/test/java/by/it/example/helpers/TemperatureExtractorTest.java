package by.it.example.helpers;

import by.it.example.beans.WeatherEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureExtractorTest {

    @Test
    public void getCelsius() {
        WeatherEntity weather = new WeatherEntity(270.15);
        double expected = -3;
        double actual = TemperatureExtractor.getCelsius(weather);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void getKelvins() {
        WeatherEntity weather = new WeatherEntity(270.15);
        double expected = 270.15;
        double actual = TemperatureExtractor.getKelvins(weather);
        assertEquals(expected, actual, 1e-10);
    }

    @Test
    public void getFahrenheit() {
        WeatherEntity weather = new WeatherEntity(270.15);
        double expected = 26.6;
        double actual = TemperatureExtractor.getFahrenheit(weather);
        assertEquals(expected, actual, 1e-10);
    }
}