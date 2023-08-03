package com.demo.weatherapp.service.impl;

import com.demo.weatherapp.dao.CountryDAO;
import com.demo.weatherapp.dao.LocationDAO;
import com.demo.weatherapp.dto.internal.LocationDTO;
import com.demo.weatherapp.dto.external.LocationData;
import com.demo.weatherapp.dto.external.LocationZone;
import com.demo.weatherapp.entity.Country;
import com.demo.weatherapp.entity.Location;
import com.demo.weatherapp.entity.TimeZone;
import com.demo.weatherapp.service.LocationService;
import com.demo.weatherapp.service.WeatherService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final WeatherService weatherService;
    private final LocationDAO locationDAO;
    private final CountryDAO countryDAO;

    public LocationServiceImpl(WeatherService weatherService, LocationDAO locationDAO, CountryDAO countryDAO) {
        this.weatherService = weatherService;
        this.locationDAO = locationDAO;
        this.countryDAO = countryDAO;
    }

    @Override
    public LocationDTO createLocation(String locationName) {
        LocationZone locationZone = weatherService.getWeatherLocation(locationName);
        LocationData locationData = locationZone.getLocation();

        String countryCode = StringUtils.deleteWhitespace(locationData.getCountry().toLowerCase());
        String locationCode = StringUtils.deleteWhitespace(locationData.getName().toLowerCase());

        String zoneOffSet = ZonedDateTime.now(ZoneId.of(locationData.getTimeZoneId())).getOffset().toString();

        Location location = locationDAO.createLocation(
                locationCode,
                locationData.getName(),
                locationData.getRegion(),
                new Country(countryCode, locationData.getCountry()),
                new TimeZone(locationData.getTimeZoneId(), zoneOffSet));

        return new LocationDTO(location);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDAO.getALlLocations();
    }

    @Override
    public Object getLocation(String locationName) {
        return locationDAO.getALlLocations();
    }


}
