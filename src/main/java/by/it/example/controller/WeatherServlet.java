package by.it.example.controller;

import by.it.example.App;
import by.it.example.model.WeatherEntity;
import by.it.example.helpers.TemperatureExtractor;
import by.it.example.helpers.TemperatureFormatter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

public class WeatherServlet extends HttpServlet {

    public static final String CITY = "city";
    public static final String VALUE = "value";
    public static final String DEFAULT_CITY = "Minsk";
    public static final char MEASURE = 'C';
    public static final String WEATHER_JSP = "weather.jsp";

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException, ServletException {

            String city = req.getParameter(CITY);
            if (city == null || city.isEmpty()) {
                city = DEFAULT_CITY;
            }

            WeatherEntity weather = App.weatherService.getWeather(city);
            double celsius = TemperatureExtractor.getCelsius(weather);
            String value = TemperatureFormatter.humanize(celsius, MEASURE);

            req.setAttribute(CITY, city);
            req.setAttribute(VALUE, value);

            RequestDispatcher dispatcher = req.getRequestDispatcher(WEATHER_JSP);
            dispatcher.forward(req, resp);
        }

    }