package com.demo.weatherapp.service.impl;

import com.demo.weatherapp.adapter.WeatherAPI;
import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.external.CurrentWeatherBase;
import com.demo.weatherapp.dto.external.LocationZone;
import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;
import com.demo.weatherapp.service.WeatherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherAPI weatherAPI;

    public WeatherServiceImpl(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    @Override
    public CurrentWeatherDTO getCurrentWeather(String location) {
        CurrentWeather currentWeather = weatherAPI.getCurrentWeather(location);
        CurrentWeatherBase current = currentWeather.getCurrent();

        return new CurrentWeatherDTO(
                StringUtils.deleteWhitespace(currentWeather.getLocation().getName()),
                current.getLastUpdatedEpoch(),
                current.getLastUpdatedLocal(),
                current.getTempC(),
                current.getCondition().getText(),
                current.getCondition().getCode(),
                current.getWindKPH(),
                current.getWindDegree(),
                current.getPrecipitationMM(),current.getHumidity(), current.getCloud(), current.getFeelsLikeC(), current.getUv());
    }

    @Override
    public LocationZone getWeatherLocation(String locationName) {
        return weatherAPI.getLocation(locationName);
    }


}
