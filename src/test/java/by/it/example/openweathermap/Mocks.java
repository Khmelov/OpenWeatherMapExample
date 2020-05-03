package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class Mocks {

    @Mock
    static WeatherClient weatherClient;

    @SuppressWarnings("SameParameterValue")
    static WeatherClient createMock(String forCity, double returnTemperature) {
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
