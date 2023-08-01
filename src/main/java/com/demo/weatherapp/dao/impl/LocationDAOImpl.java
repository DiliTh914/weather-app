package com.demo.weatherapp.dao.impl;

import com.demo.weatherapp.dao.LocationDAO;
import com.demo.weatherapp.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationDAOImpl implements LocationDAO {

    private final LocationRepository locationRepository;

    public LocationDAOImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
}
