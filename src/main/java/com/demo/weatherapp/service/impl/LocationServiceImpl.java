package com.demo.weatherapp.service.impl;

import com.demo.weatherapp.dao.CountryDAO;
import com.demo.weatherapp.dao.LocationDAO;
import com.demo.weatherapp.dto.CityDTO;
import com.demo.weatherapp.external.WeatherAPI;
import com.demo.weatherapp.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final WeatherAPI weatherAPI;
    private final LocationDAO locationDAO;
    private final CountryDAO countryDAO;

    public LocationServiceImpl(WeatherAPI weatherAPI, LocationDAO locationDAO, CountryDAO countryDAO) {
        this.weatherAPI = weatherAPI;
        this.locationDAO = locationDAO;
        this.countryDAO = countryDAO;
    }

    @Override
    public CityDTO createLocation(String locationName) {
        weatherAPI.getLocation(locationName);
        return null;
    }
}
