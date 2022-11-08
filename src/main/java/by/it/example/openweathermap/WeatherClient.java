package by.it.example.openweathermap;

import by.it.example.App;
import by.it.example.beans.WeatherDetails;
import by.it.example.interfaces.WeatherGetter;
import retrofit.RestAdapter;

public class WeatherClient implements WeatherGetter {

    private static final WeatherGetter clientWeatherDetails = new RestAdapter
            .Builder()
            .setEndpoint(App.BASE_URL)
            .build()
            .create(WeatherGetter.class);

    @Override
    public WeatherDetails getWeatherDetails(String query) {
        return clientWeatherDetails.getWeatherDetails(query);
    }
}
