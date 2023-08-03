package com.demo.weatherapp.dao.impl;

import com.demo.weatherapp.dao.WeatherHistoryDAO;
import com.demo.weatherapp.entity.weather.AtmosphereHistory;
import com.demo.weatherapp.entity.weather.PrecipitationHistory;
import com.demo.weatherapp.entity.weather.TemperatureHistory;
import com.demo.weatherapp.entity.weather.WeatherCondition;
import com.demo.weatherapp.entity.weather.WeatherHistory;
import com.demo.weatherapp.entity.weather.WindHistory;
import com.demo.weatherapp.repository.WeatherHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class WeatherHistoryDAOImpl implements WeatherHistoryDAO {

    private final WeatherHistoryRepository weatherHistoryRepository;

    public WeatherHistoryDAOImpl(WeatherHistoryRepository weatherHistoryRepository) {
        this.weatherHistoryRepository = weatherHistoryRepository;
    }

    @Override
    public WeatherHistory saveWeatherHistory(UUID id, String locationId, WeatherCondition condition, WindHistory windHistory,
                                             TemperatureHistory temperatureHistory, AtmosphereHistory atmosphereHistory, PrecipitationHistory precipitationHistory, Instant lastUpdatedZ, LocalDateTime lastUpdatedLocal) {
        return weatherHistoryRepository.save(
                new WeatherHistory(id, locationId, condition, windHistory, temperatureHistory, atmosphereHistory, precipitationHistory, lastUpdatedZ, lastUpdatedLocal));
    }
}
