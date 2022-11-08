package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherClientGoodTest {


    @Test
    public void getWeatherDetailsTest() {
        WeatherClient weatherClient = Mocks.createMock(Data.CITY, Data.TEMPERATURE);
        WeatherDetails details = weatherClient.getWeatherDetails(Data.CITY);
        WeatherDetails.Status status = details.getStatus();
        assertEquals(Data.TEMPERATURE, status.getTemperature(), 1e-10);
    }
}