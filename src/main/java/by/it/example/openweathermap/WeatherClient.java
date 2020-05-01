package by.it.example.openweathermap;

import by.it.example.App;
import by.it.example.beans.WeatherDetails;
import by.it.example.interfaces.IWeatherDetails;
import retrofit.RestAdapter;

public class WeatherClient implements IWeatherDetails {

    public WeatherClient() {
    }

    private static final IWeatherDetails clientWeatherDetails = new RestAdapter
            .Builder()
            .setEndpoint(App.BASE_URL)
            .build()
            .create(IWeatherDetails.class);

    @Override
    public WeatherDetails getWeatherDetails(String query) {
        return clientWeatherDetails.getWeatherDetails(query);
    }
}
