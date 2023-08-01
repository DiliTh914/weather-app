package com.demo.weatherapp.service;

import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.internal.LocationDTO;
import com.demo.weatherapp.model.Location;

import java.util.List;

public interface LocationService {

    LocationDTO createLocation(String locationName);

    List<Location> getAllLocations();

    CurrentWeather getCurrentWeather(String location);


}
