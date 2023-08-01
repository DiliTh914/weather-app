package com.demo.weatherapp.dao;

import com.demo.weatherapp.model.Location;

import java.util.List;

public interface LocationDAO {

    Location createLocation(String locationCode, String name, String region, String countryCode, String timeZoneId, String timeZoneOffSet);

    List<Location> getALlLocations();
}
