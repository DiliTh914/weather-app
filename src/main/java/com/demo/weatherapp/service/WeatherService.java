package com.demo.weatherapp.service;

import com.demo.weatherapp.dto.external.LocationZone;
import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;

public interface WeatherService {
    CurrentWeatherDTO getCurrentWeather(String location);

    LocationZone getWeatherLocation(String locationName);
}
