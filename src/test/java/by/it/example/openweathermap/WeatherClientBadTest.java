package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherClientBadTest {

    @Test
    public void getWeatherDetails() {
        WeatherClient weatherClient = new WeatherClient();
        WeatherDetails details = weatherClient.getWeatherDetails("Minsk");
        assertNotNull(details);
        WeatherDetails.Status status = details.getStatus();
        assertNotNull(status);
        double temperature = status.getTemperature();
        assertTrue(temperature >= 0);
    }
}