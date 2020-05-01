package by.it.example.interfaces;


import by.it.example.beans.Weather;

@FunctionalInterface
public interface IWeather {
    Weather getWeather(String query);
}
