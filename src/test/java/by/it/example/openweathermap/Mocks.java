package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class Mocks {

    static WeatherClient weatherClient;

    @SuppressWarnings("SameParameterValue")
    public static WeatherClient createMock(String forCity, double returnTemperature) {
        weatherClient = Mockito.mock(WeatherClient.class);
        WeatherDetails.Status status = new WeatherDetails.Status();
        status.setTemperature(returnTemperature);
        WeatherDetails weatherDetails = new WeatherDetails();
        weatherDetails.setStatus(status);
        when(weatherClient.getWeatherDetails(forCity))
                .thenReturn(weatherDetails);
        return weatherClient;
    }

}
