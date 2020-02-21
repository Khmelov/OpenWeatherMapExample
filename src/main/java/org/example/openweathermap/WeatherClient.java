package org.example.openweathermap;

import org.example.Config;
import org.example.beans.WeatherDetails;
import org.example.interfaces.IWeatherDetails;
import retrofit.RestAdapter;

public class WeatherClient implements IWeatherDetails {

    public WeatherClient() {
    }

    private static final IWeatherDetails clientWeatherDetails = new RestAdapter
            .Builder()
            .setEndpoint(Config.BASE_URL)
            .build()
            .create(IWeatherDetails.class);

    @Override
    public WeatherDetails getWeatherDetails(String query) {
        return clientWeatherDetails.getWeatherDetails(query);
    }
}
