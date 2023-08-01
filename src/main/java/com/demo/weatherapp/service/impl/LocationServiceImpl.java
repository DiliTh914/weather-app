package com.demo.weatherapp.service.impl;

import com.demo.weatherapp.dao.CountryDAO;
import com.demo.weatherapp.dao.LocationDAO;
import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.dto.internal.LocationDTO;
import com.demo.weatherapp.dto.external.LocationData;
import com.demo.weatherapp.dto.external.LocationZone;
import com.demo.weatherapp.adapter.WeatherAPI;
import com.demo.weatherapp.model.Location;
import com.demo.weatherapp.service.LocationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final WeatherAPI weatherAPI;
    private final LocationDAO locationDAO;
    private final CountryDAO countryDAO;

    public LocationServiceImpl(WeatherAPI weatherAPI, LocationDAO locationDAO, CountryDAO countryDAO) {
        this.weatherAPI = weatherAPI;
        this.locationDAO = locationDAO;
        this.countryDAO = countryDAO;
    }

    @Override
    public LocationDTO createLocation(String locationName) {
        LocationZone locationZone = weatherAPI.getLocation(locationName);
        LocationData locationData = locationZone.getLocation();

        String countryCode = StringUtils.deleteWhitespace(locationData.getCountry());

        if (!countryDAO.isCountryExists(countryCode)) {
            countryDAO.createCountry(locationData.getCountry(), countryCode);
        }

        String locationCode = StringUtils.deleteWhitespace(locationData.getName());
        String zoneOffSet = ZonedDateTime.now(ZoneId.of(locationData.getTimeZoneId())).getOffset().toString();

        Location location = locationDAO.createLocation(locationCode, locationData.getName(), locationData.getRegion(), countryCode, locationData.getTimeZoneId(), zoneOffSet);

        LocationDTO locationDTO = new LocationDTO();
        BeanUtils.copyProperties(location, locationDTO);
        locationDTO.setCountryName(locationData.getCountry());

        return locationDTO;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDAO.getALlLocations();
    }

    @Override
    public CurrentWeather getCurrentWeather(String location) {
        return weatherAPI.getCurrentWeather(location);
    }
}
