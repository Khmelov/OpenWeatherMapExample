package org.example.helpers;

import org.example.beans.Weather;

public class TemperatureExtractor {

    public static double getCelsius(Weather weather) {
        double kelvin = weather.getTemperature();
        return kelvin - 273.15;
    }

    public static double getKelvins(Weather weather) {
        return weather.getTemperature();
    }

    public static double getFahrenheit(Weather weather) {
        return 32 + 9.0 / 5.0 * getCelsius(weather);
    }

}
