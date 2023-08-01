package com.demo.weatherapp.service.impl;

import com.demo.weatherapp.adapter.WeatherAPI;
import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.service.WeatherService;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherAPI weatherAPI;

    public WeatherServiceImpl(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    @Override
    public CurrentWeather getCurrentWeather(String location) {
        return weatherAPI.getCurrentWeather(location);
    }
}
