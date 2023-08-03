package com.demo.weatherapp.dao;

import com.demo.weatherapp.entity.Country;
import com.demo.weatherapp.entity.Location;
import com.demo.weatherapp.entity.TimeZone;

import java.util.List;

public interface LocationDAO {

    Location createLocation(String id, String name, String region, Country country, TimeZone timeZone);

    List<Location> getALlLocations();
}
