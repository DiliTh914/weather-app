package com.demo.weatherapp.dto.external;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CurrentWeatherBase {

    @JsonProperty("temp_c")
    private Double tempC;
}
