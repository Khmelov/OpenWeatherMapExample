package by.it.example.beans;

import lombok.Data;
import lombok.AllArgsConstructor;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
public class WeatherTO {

    private String city;
    private String value;

}
