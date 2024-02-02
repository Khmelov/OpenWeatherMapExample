package by.it.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
public class WeatherTO {

    private String city;
    private String value;

}
