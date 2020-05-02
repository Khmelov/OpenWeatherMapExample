package by.it.example.openweathermap;

import by.it.example.beans.Weather;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherServiceGoodTest {

    private final String CITY = "Minsk";
    private final double TEMPERATURE = 280;

    @Test
    public void getWeather() {
        WeatherClient client = Mocks.createMock(CITY, TEMPERATURE);
        WeatherService service = new WeatherService(client);
        Weather weather = service.getWeather("Minsk");
        double temperature = weather.getTemperature();
        assertEquals(TEMPERATURE, temperature, 1e-10);
    }
}