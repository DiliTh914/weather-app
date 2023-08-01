package com.demo.weatherapp.adapter;

import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.external.LocationZone;

public interface WeatherAPI {

    LocationZone getLocation(String locationName);

    CurrentWeather getCurrentWeather(String location);
}
