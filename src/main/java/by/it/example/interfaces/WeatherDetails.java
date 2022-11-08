package by.it.example.interfaces;

import by.it.example.App;
import retrofit.http.GET;
import retrofit.http.Query;

@FunctionalInterface
public interface WeatherDetails {
        @GET("/data/2.5/weather?appid="+ App.APP_KEY)
        by.it.example.beans.WeatherDetails getWeatherDetails(@Query("q") String query);
}
