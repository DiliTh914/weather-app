package com.demo.weatherapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String locationCode;

    private String name;

    private String region;

    private String countryCode;

    private String timeZoneId;

    private String timeZoneOffSet;

    public Location(String locationCode, String name, String region, String countryCode, String timeZoneId,String timeZoneOffSet) {
        this.locationCode = locationCode;
        this.name = name;
        this.region = region;
        this.countryCode = countryCode;
        this.timeZoneId = timeZoneId;
        this.timeZoneOffSet = timeZoneOffSet;
    }
}
