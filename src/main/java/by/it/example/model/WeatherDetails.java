package by.it.example.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WeatherDetails {

    @SerializedName(value = "main")
    private Status status;

    @Data
    public static class Status {
        @SerializedName(value = "temp")
        double temperature;

    }
}


