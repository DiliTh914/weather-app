package com.demo.weatherapp.service;

import com.demo.weatherapp.dto.external.CurrentWeather;

public interface WeatherService {
    CurrentWeather getCurrentWeather(String location);
}
