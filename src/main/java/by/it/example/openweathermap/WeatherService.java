package by.it.example.openweathermap;

import by.it.example.beans.WeatherEntity;
import by.it.example.interfaces.Weather;
import by.it.example.interfaces.WeatherDetails;

public class WeatherService implements Weather {

    private final WeatherDetails client;

    public WeatherService(WeatherDetails client) {
        this.client = client;
    }

    @Override
    public WeatherEntity getWeather(String query) {
        by.it.example.beans.WeatherDetails details = client.getWeatherDetails(query);
        double temperature = details.getStatus().getTemperature();
        return new WeatherEntity(temperature);
    }

}
