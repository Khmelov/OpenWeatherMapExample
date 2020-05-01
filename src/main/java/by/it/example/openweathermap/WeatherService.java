package by.it.example.openweathermap;

import by.it.example.beans.Weather;
import by.it.example.beans.WeatherDetails;
import by.it.example.interfaces.IWeather;
import by.it.example.interfaces.IWeatherDetails;

public class WeatherService implements IWeather {

    private final IWeatherDetails client;

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
