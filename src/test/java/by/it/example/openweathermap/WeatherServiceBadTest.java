package by.it.example.openweathermap;

import by.it.example.model.WeatherEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherServiceBadTest {

    @Test
    public void getWeather() {
        WeatherClient client = new WeatherClient();
        assertNotNull(client);
        WeatherService service = new WeatherService(client);
        assertNotNull(service);
        WeatherEntity weather = service.getWeather(Data.CITY);
        assertNotNull(weather);
        double temperature = weather.getTemperature();
        assertTrue(temperature >= 0);

    }
}