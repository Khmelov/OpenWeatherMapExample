package org.example.openweathermap;

import org.example.Config;
import org.example.beans.WeatherDetails;
import org.example.interfaces.IWeatherDetails;
import retrofit.RestAdapter;

public class WeatherClient implements IWeatherDetails {

    private static final IWeatherDetails clientWeatherDetails = new RestAdapter
            .Builder()
            .setEndpoint(Config.BASE_URL)
            .build()
            .create(IWeatherDetails.class);

    public WeatherClient() {
    }

    @Override
    public WeatherDetails getWeatherDetails(String query) {
        return clientWeatherDetails.getWeatherDetails(query);
    }
}
