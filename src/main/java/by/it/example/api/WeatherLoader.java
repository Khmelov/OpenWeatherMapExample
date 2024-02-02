package by.it.example.api;

import by.it.example.App;
import by.it.example.model.WeatherDetails;
import retrofit.http.GET;
import retrofit.http.Query;

@FunctionalInterface
public interface WeatherLoader {
        @GET("/data/2.5/weather?appid="+ App.APP_KEY)
        WeatherDetails getWeatherDetails(@Query("q") String query);
}
