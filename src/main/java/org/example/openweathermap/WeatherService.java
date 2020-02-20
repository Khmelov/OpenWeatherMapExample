package org.example.openweathermap;

import org.example.beans.Weather;
import org.example.beans.WeatherDetails;
import org.example.interfaces.IWeatherDetails;
import org.example.interfaces.IWeather;

public class WeatherService implements IWeather {

    private IWeatherDetails client;

    public WeatherService(IWeatherDetails client) {
        this.client = client;
    }

    @Override
    public Weather getWeather(String query) {
        WeatherDetails details = client.getWeatherDetails(query);
        double temperature = details.getStatus().getTemperature();
        return new Weather(temperature);
    }

}
