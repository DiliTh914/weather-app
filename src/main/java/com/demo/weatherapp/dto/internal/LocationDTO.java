package com.demo.weatherapp.dto.internal;

import com.demo.weatherapp.entity.location.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class LocationDTO {

    private String id;
    private String name;
    private String region;
    private String countryId;
    private String countryName;
    private String timeZoneId;
    private String timeZoneOffSet;

    public LocationDTO(Location location) {
        this.id = location.getId();
        this.name = location.getName();
        this.region = location.getRegion();
        this.countryId = location.getCountry().getId();
        this.countryName = location.getCountry().getName();
        this.timeZoneId = location.getTimeZone().getId();
        this.timeZoneOffSet = location.getTimeZone().getOffSet();
    }
}
