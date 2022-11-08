package by.it.example.interfaces;

import by.it.example.App;
import by.it.example.beans.WeatherDetails;
import retrofit.http.GET;
import retrofit.http.Query;

@FunctionalInterface
public interface WeatherGetter {
        @GET("/data/2.5/weather?appid="+ App.APP_KEY)
        WeatherDetails getWeatherDetails(@Query("q") String query);
}
