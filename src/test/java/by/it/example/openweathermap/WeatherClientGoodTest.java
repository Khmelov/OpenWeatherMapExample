package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherClientGoodTest {


    @Test
    public void getWeatherDetails() {
        WeatherClient weatherClient = Mocks.createMock(Data.CITY, Data.TEMPERATURE);
        WeatherDetails details = weatherClient.getWeatherDetails(Data.CITY);
        WeatherDetails.Status status = details.getStatus();
        assertEquals(Data.TEMPERATURE, status.getTemperature(), 1e-10);
    }
}