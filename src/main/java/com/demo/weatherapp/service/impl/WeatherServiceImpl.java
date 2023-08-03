package com.demo.weatherapp.service.impl;

import com.demo.weatherapp.adapter.WeatherAPI;
import com.demo.weatherapp.dao.WeatherHistoryDAO;
import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.external.CurrentWeatherBase;
import com.demo.weatherapp.dto.external.LocationZone;
import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;
import com.demo.weatherapp.entity.weather.AtmosphereHistory;
import com.demo.weatherapp.entity.weather.PrecipitationHistory;
import com.demo.weatherapp.entity.weather.TemperatureHistory;
import com.demo.weatherapp.entity.weather.WeatherCondition;
import com.demo.weatherapp.entity.weather.WindHistory;
import com.demo.weatherapp.service.LocationService;
import com.demo.weatherapp.service.WeatherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherAPI weatherAPI;
    private final WeatherHistoryDAO weatherHistoryDAO;

    public WeatherServiceImpl(WeatherAPI weatherAPI, WeatherHistoryDAO weatherHistoryDAO) {
        this.weatherAPI = weatherAPI;
        this.weatherHistoryDAO = weatherHistoryDAO;
    }

    @Override
    public CurrentWeatherDTO getCurrentWeather(String location) {
        CurrentWeather currentWeather = weatherAPI.getCurrentWeather(location);
        CurrentWeatherBase current = currentWeather.getCurrent();

        return new CurrentWeatherDTO(
                currentWeather.getLocation().getName(),
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

    @Override
    public void saveWeatherHistory(CurrentWeatherDTO currentWeatherDTO) {
        UUID historyEventId = UUID.randomUUID();
        String locationId = StringUtils.deleteWhitespace(currentWeatherDTO.getLocation().toLowerCase());
        WeatherCondition weatherCondition = new WeatherCondition(currentWeatherDTO.getConditionCode(), currentWeatherDTO.getCondition());
        WindHistory windHistory = new WindHistory(historyEventId, currentWeatherDTO.getWindKPH(), currentWeatherDTO.getWindDegree());
        TemperatureHistory temperatureHistory = new TemperatureHistory(historyEventId, currentWeatherDTO.getTempC(), currentWeatherDTO.getFeelsLikeC());
        AtmosphereHistory atmosphereHistory = new AtmosphereHistory(historyEventId, currentWeatherDTO.getHumidity(), currentWeatherDTO.getCloud(), currentWeatherDTO.getUv());
        PrecipitationHistory precipitationHistory = new PrecipitationHistory(historyEventId, currentWeatherDTO.getPrecipitationMM());

        weatherHistoryDAO.saveWeatherHistory(historyEventId, locationId,
                weatherCondition, windHistory, temperatureHistory, atmosphereHistory, precipitationHistory,
                currentWeatherDTO.getLastUpdatedZ(), currentWeatherDTO.getLastUpdatedLocal());
    }


}
