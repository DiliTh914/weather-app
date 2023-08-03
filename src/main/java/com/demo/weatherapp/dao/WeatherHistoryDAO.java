package com.demo.weatherapp.dao;

import com.demo.weatherapp.entity.weather.AtmosphereHistory;
import com.demo.weatherapp.entity.weather.PrecipitationHistory;
import com.demo.weatherapp.entity.weather.TemperatureHistory;
import com.demo.weatherapp.entity.weather.WeatherCondition;
import com.demo.weatherapp.entity.weather.WeatherHistory;
import com.demo.weatherapp.entity.weather.WindHistory;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public interface WeatherHistoryDAO {

    WeatherHistory saveWeatherHistory(UUID id, String locationId, WeatherCondition condition, WindHistory windHistory, TemperatureHistory temperatureHistory,
                                      AtmosphereHistory atmosphereHistory, PrecipitationHistory precipitationHistory, Instant lastUpdatedZ, LocalDateTime lastUpdatedLocal);

}
