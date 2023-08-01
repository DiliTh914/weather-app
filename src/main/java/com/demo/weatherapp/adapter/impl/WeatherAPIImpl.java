package com.demo.weatherapp.adapter.impl;

import com.demo.weatherapp.config.ConfigProperties;
import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.external.LocationZone;
import com.demo.weatherapp.adapter.WeatherAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherAPIImpl implements WeatherAPI {

    private final ConfigProperties properties;
    private final RestTemplate restTemplate;

    public WeatherAPIImpl(ConfigProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    @Override
    public LocationZone getLocation(String locationName) {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getWeatherApi().getBaseUrl()).path("/v1/timezone.json")
                .queryParam("key", properties.getWeatherApi().getAccessKey())
                .queryParam("q", locationName).toUriString();

        ResponseEntity<LocationZone> response = restTemplate.getForEntity(url, LocationZone.class);

        return response.getBody();

    }

    @Override
    public CurrentWeather getCurrentWeather(String location) {
        String url = UriComponentsBuilder.fromHttpUrl(properties.getWeatherApi().getBaseUrl()).path("/v1/current.json")
                .queryParam("key", properties.getWeatherApi().getAccessKey())
                .queryParam("q", location).toUriString();

        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity(url, CurrentWeather.class);

        return response.getBody();
    }

}
