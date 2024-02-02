package by.it.example.openweathermap;

import by.it.example.App;
import by.it.example.model.WeatherDetails;
import by.it.example.api.WeatherLoader;
import retrofit.RestAdapter;

public class WeatherClient implements WeatherLoader {

    private static final WeatherLoader clientWeatherDetails = new RestAdapter
            .Builder()
            .setEndpoint(App.BASE_URL)
            .build()
            .create(WeatherLoader.class);

    @Override
    public WeatherDetails getWeatherDetails(String query) {
        return clientWeatherDetails.getWeatherDetails(query);
    }
}
