package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import by.it.example.beans.WeatherEntity;
import by.it.example.interfaces.Weather;
import by.it.example.interfaces.WeatherGetter;

public class WeatherService implements Weather {

    private final WeatherGetter client;

    public WeatherService(WeatherGetter client) {
        this.client = client;
    }

    @Override
    public WeatherEntity getWeather(String query) {
        WeatherDetails details = client.getWeatherDetails(query);
        double temperature = details.getStatus().getTemperature();
        return new WeatherEntity(temperature);
    }

}
