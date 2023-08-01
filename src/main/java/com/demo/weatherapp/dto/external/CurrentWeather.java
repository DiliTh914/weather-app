package com.demo.weatherapp.dto.external;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CurrentWeather {
    private LocationData location;
    private CurrentWeatherBase current;
}
