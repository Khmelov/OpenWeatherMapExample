package by.it.example.openweathermap;

import by.it.example.App;
import by.it.example.interfaces.WeatherDetails;
import retrofit.RestAdapter;

public class WeatherClient implements WeatherDetails {

    private static final WeatherDetails clientWeatherDetails = new RestAdapter
            .Builder()
            .setEndpoint(App.BASE_URL)
            .build()
            .create(WeatherDetails.class);

    @Override
    public by.it.example.beans.WeatherDetails getWeatherDetails(String query) {
        return clientWeatherDetails.getWeatherDetails(query);
    }
}
