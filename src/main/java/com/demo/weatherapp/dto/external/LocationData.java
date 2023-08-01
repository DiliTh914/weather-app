package com.demo.weatherapp.dto.external;

import com.demo.weatherapp.serializer.InstantDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@ToString
@Getter
@Setter
public class LocationData {

    private String name;

    private String region;

    private String country;

    private Double lat;

    private Double lon;

    @JsonProperty("tz_id")
    private String timeZoneId;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("localtime_epoch")
    private Instant localTimeEpoch;

    private String localTime;
}
