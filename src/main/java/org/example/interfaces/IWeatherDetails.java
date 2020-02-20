package org.example.interfaces;

import org.example.Config;
import org.example.beans.WeatherDetails;
import retrofit.http.GET;
import retrofit.http.Query;

@FunctionalInterface
public interface IWeatherDetails {
        @GET("/data/2.5/weather?appid="+ Config.APP_KEY)
        WeatherDetails getWeatherDetails(@Query("q") String query);
}
