package by.it.example.beans;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class WeatherTO {

    private String city;
    private String value;

}
