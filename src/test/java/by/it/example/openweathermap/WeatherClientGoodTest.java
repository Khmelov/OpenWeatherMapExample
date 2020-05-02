package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherClientGoodTest {

    private final String CITY = "Minsk";
    private final double TEMPERATURE = 280;

    @Test
    public void getWeatherDetails() {
        WeatherClient weatherClient = Mocks.createMock(CITY, TEMPERATURE);
        WeatherDetails details = weatherClient.getWeatherDetails("Minsk");
        WeatherDetails.Status status = details.getStatus();
        assertEquals(TEMPERATURE, status.getTemperature(), 1e-10);
    }
}