package com.demo.weatherapp.service;

import com.demo.weatherapp.dto.internal.LocationDTO;
import com.demo.weatherapp.entity.location.Location;

import java.util.List;

public interface LocationService {

    LocationDTO createLocation(String locationName);

    List<Location> getAllLocations();

    Object getLocation(String locationName);

    String getLocationId(String locationName);

}
