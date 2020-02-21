package org.example;

import org.example.beans.Weather;
import org.example.helpers.TemperatureExtractor;
import org.example.helpers.TemperatureFormatter;
import org.example.openweathermap.WeatherClient;
import org.example.openweathermap.WeatherService;

public class App {
    private static final String CITY = "Bilbo";

    public static void main(String[] args) {

        WeatherClient client = new WeatherClient();
        WeatherService weatherService = new WeatherService(client);

        Weather weather = weatherService.getWeather(CITY);
        double celsius = TemperatureExtractor.getCelsius(weather);

        String out = TemperatureFormatter.humanize(celsius, 'C');
        System.out.printf("Temperature in %s %s\n", CITY, out);
    }
}
