package com.demo.weatherapp.dto.internal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {

    private Integer id;
    private String locationCode;
    private String name;
    private String region;
    private String countryCode;
    private String countryName;
    private String timeZoneId;
    private String timeZoneOffSet;
}
