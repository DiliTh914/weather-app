package com.demo.weatherapp.dao.impl;

import com.demo.weatherapp.dao.LocationDAO;
import com.demo.weatherapp.model.Location;
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
    public Location createLocation(String locationCode, String name, String region, String countryCode, String timeZoneId, String timeZoneOffSet) {
        return locationRepository.save(new Location(locationCode, name, region, countryCode, timeZoneId, timeZoneOffSet));
    }

    @Override
    public List<Location> getALlLocations() {
        return locationRepository.findAll();
    }
}
