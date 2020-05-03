package by.it.example;

import by.it.example.openweathermap.WeatherClient;
import by.it.example.openweathermap.WeatherService;

public class App {

    private App() {
    }

    /**
     * If not work, set yours app_key openweathermap
     */
    public static final String APP_KEY = "f9f00838c82ff602fb4841bd9f98e167";

    public static final String BASE_URL = "http://api.openweathermap.org/";

    public static final WeatherClient client = new WeatherClient();

    public static final WeatherService weatherService = new WeatherService(client);
}
