package by.it.example.controller;

import by.it.example.App;
import by.it.example.beans.Weather;
import by.it.example.helpers.TemperatureExtractor;
import by.it.example.helpers.TemperatureFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WeatherServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException, ServletException {

            String city = req.getParameter("city");
            if (city == null || city.isEmpty()) {
                city = "Minsk";
            }

            Weather weather = App.weatherService.getWeather(city);
            double celsius = TemperatureExtractor.getCelsius(weather);
            String value = TemperatureFormatter.humanize(celsius, 'C');

            req.setAttribute("city", city);
            req.setAttribute("value", value);

            RequestDispatcher dispatcher = req.getRequestDispatcher("weather.jsp");
            dispatcher.forward(req, resp);
        }

    }