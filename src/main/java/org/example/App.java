package org.example;

import org.example.beans.Weather;
import org.example.openweathermap.WeatherClient;
import org.example.openweathermap.WeatherService;

public class App {
    private static final String CITY = "Moscow";

    public static void main(String[] args) {

        WeatherClient client = new WeatherClient();
        WeatherService weatherService = new WeatherService(client);

        Weather weather = weatherService.getWeather(CITY);
        double temperature = weather.getTemperature();

        System.out.printf("Temperature in %s t=%f\n", CITY, temperature);
    }
}
