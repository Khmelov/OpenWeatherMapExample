package by.it.example.openweathermap;

import by.it.example.model.WeatherDetails;
import by.it.example.model.WeatherEntity;
import by.it.example.api.Weather;
import by.it.example.api.WeatherLoader;

public class WeatherService implements Weather {

    private final WeatherLoader client;

    public WeatherService(WeatherLoader client) {
        this.client = client;
    }

    @Override
    public WeatherEntity getWeather(String query) {
        WeatherDetails details = client.getWeatherDetails(query);
        double temperature = details.getStatus().getTemperature();
        return new WeatherEntity(temperature);
    }

}
