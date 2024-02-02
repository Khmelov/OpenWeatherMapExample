package by.it.example.helpers;

import by.it.example.model.WeatherEntity;

public class TemperatureExtractor {

    public static final double ABSOLUTE_ZERO_IN_CELSIUS = 273.15;

    private TemperatureExtractor() {
    }

    public static double getCelsius(WeatherEntity weather) {
        double kelvin = weather.getTemperature();
        return kelvin - ABSOLUTE_ZERO_IN_CELSIUS;
    }

    public static double getKelvins(WeatherEntity weather) {
        return weather.getTemperature();
    }

    public static double getFahrenheit(WeatherEntity weather) {
        return 32 + 9.0 / 5.0 * getCelsius(weather);
    }

}
