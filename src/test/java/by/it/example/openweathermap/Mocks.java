package by.it.example.openweathermap;

import by.it.example.beans.WeatherDetails;
import lombok.experimental.UtilityClass;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

@UtilityClass
public class Mocks {

    @SuppressWarnings("SameParameterValue")
    public static WeatherClient createMock(String forCity, double returnTemperature) {
        WeatherClient weatherClient = Mockito.mock(WeatherClient.class);
        WeatherDetails.Status status = new WeatherDetails.Status();
        status.setTemperature(returnTemperature);
        WeatherDetails weatherDetails = new WeatherDetails();
        weatherDetails.setStatus(status);
        when(weatherClient.getWeatherDetails(forCity))
                .thenReturn(weatherDetails);
        return weatherClient;
    }

}
