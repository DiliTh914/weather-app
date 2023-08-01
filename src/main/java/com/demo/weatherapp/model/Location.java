package com.demo.weatherapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(unique = true)
    private String locationCode;

    @Setter
    private String name;

    @Setter
    private String region;

    @Setter
    private String countryCode;

    @Setter
    private String timeZoneId;

    public Location(String locationCode, String name, String region, String countryCode, String timeZoneId) {
        this.locationCode = locationCode;
        this.name = name;
        this.region = region;
        this.countryCode = countryCode;
        this.timeZoneId = timeZoneId;
    }
}
