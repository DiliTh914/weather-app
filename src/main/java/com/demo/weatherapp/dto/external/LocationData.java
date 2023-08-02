package com.demo.weatherapp.dto.external;

import com.demo.weatherapp.serializer.jackson.InstantEpochSecDeserializer;
import com.demo.weatherapp.serializer.jackson.InstantEpochSecSerializer;
import com.demo.weatherapp.serializer.jackson.LocalDateTimeStringDeserializer;
import com.demo.weatherapp.serializer.jackson.LocalDateTimeStringSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;

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

    @JsonSerialize(using = InstantEpochSecSerializer.class)
    @JsonDeserialize(using = InstantEpochSecDeserializer.class)
    @JsonProperty("localtime_epoch")
    private Instant localTimeEpoch;

    @JsonSerialize(using = LocalDateTimeStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeStringDeserializer.class)
    private LocalDateTime localTime;
}
