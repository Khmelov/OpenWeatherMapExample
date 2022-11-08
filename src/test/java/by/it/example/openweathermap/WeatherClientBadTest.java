package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WeatherClientBadTest {

    @Test
    public void getWeatherDetails() {
        WeatherClient weatherClient = new WeatherClient();
        WeatherDetails details = weatherClient.getWeatherDetails(Data.CITY);
        assertNotNull(details);
        WeatherDetails.Status status = details.getStatus();
        assertNotNull(status);
        double temperature = status.getTemperature();
        assertTrue(temperature >= 0);
    }
}