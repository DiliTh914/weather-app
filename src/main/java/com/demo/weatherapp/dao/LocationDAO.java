package com.demo.weatherapp.dao;

import com.demo.weatherapp.entity.location.Country;
import com.demo.weatherapp.entity.location.Location;
import com.demo.weatherapp.entity.location.TimeZone;

import java.util.List;

public interface LocationDAO {

    Location createLocation(String id, String name, String region, Country country, TimeZone timeZone);

    List<Location> getALlLocations();
}
