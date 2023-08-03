package com.demo.weatherapp.dao.impl;

import com.demo.weatherapp.dao.LocationDAO;
import com.demo.weatherapp.entity.location.Country;
import com.demo.weatherapp.entity.location.Location;
import com.demo.weatherapp.entity.location.TimeZone;
import com.demo.weatherapp.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationDAOImpl implements LocationDAO {

    private final LocationRepository locationRepository;

    public LocationDAOImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(String id, String name, String region, Country country, TimeZone timeZone) {
        return locationRepository.save(new Location(id, name, region, country, timeZone));
    }

    @Override
    public List<Location> getALlLocations() {
        return locationRepository.findAll();
    }
}
