package by.it.example.beans;

import lombok.Data;
import com.google.gson.annotations.SerializedName;

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


