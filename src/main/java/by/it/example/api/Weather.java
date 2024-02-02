package by.it.example.api;


import by.it.example.model.WeatherEntity;

@SuppressWarnings("unused")
@FunctionalInterface
public interface Weather {
    WeatherEntity getWeather(String query);
}
