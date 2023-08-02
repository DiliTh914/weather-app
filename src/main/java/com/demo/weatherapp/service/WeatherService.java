package com.demo.weatherapp.service;

import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;

public interface WeatherService {
    CurrentWeatherDTO getCurrentWeather(String location);
}
