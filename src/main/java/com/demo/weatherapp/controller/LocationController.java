package com.demo.weatherapp.controller;

import com.demo.weatherapp.dto.internal.LocationDTO;
import com.demo.weatherapp.service.LocationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public LocationDTO addLocation(@RequestParam String location) {
        return locationService.createLocation(location);
    }
}
