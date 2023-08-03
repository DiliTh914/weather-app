package com.demo.weatherapp.controller;

import com.demo.weatherapp.dto.internal.LocationDTO;
import com.demo.weatherapp.dto.internal.LocationInboundDTO;
import com.demo.weatherapp.service.LocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public LocationDTO addLocation(@RequestBody LocationInboundDTO inboundDTO) {
        return locationService.createLocation(inboundDTO.getName());
    }

    @GetMapping("{locationName}")
    public Object getLocation(@PathVariable String locationName) {
        return locationService.getLocation(locationName);
    }
}
