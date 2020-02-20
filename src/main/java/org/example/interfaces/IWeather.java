package org.example.interfaces;


import org.example.beans.Weather;

@FunctionalInterface
public interface IWeather {
    Weather getWeather(String query);
}
