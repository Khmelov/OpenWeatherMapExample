package by.it.example.interfaces;


import by.it.example.beans.WeatherEntity;

@SuppressWarnings("unused")
@FunctionalInterface
public interface Weather {
    WeatherEntity getWeather(String query);
}
