package com.demo.weatherapp.external.impl;

import com.demo.weatherapp.config.ConfigProperties;
import com.demo.weatherapp.external.WeatherAPI;
import org.springframework.stereotype.Service;

@Service
public class WeatherAPIImpl implements WeatherAPI {

    private ConfigProperties properties;

    public WeatherAPIImpl(ConfigProperties properties) {
        this.properties = properties;
    }

    @Override
    public void getLocation(String locationName) {
        System.out.println("");

    }

}
