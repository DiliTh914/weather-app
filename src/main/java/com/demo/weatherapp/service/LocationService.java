package com.demo.weatherapp.service;

import com.demo.weatherapp.dto.CityDTO;

public interface LocationService {

    CityDTO createLocation(String locationName);
}
