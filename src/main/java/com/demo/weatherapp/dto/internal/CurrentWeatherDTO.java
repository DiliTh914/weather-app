package com.demo.weatherapp.dto.internal;

import com.demo.weatherapp.serializer.jackson.InstantStringDeserializer;
import com.demo.weatherapp.serializer.jackson.InstantStringSerializer;
import com.demo.weatherapp.serializer.jackson.LocalDateTimeStringDeserializer;
import com.demo.weatherapp.serializer.jackson.LocalDateTimeStringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class CurrentWeatherDTO {

    private String location;

    @JsonSerialize(using = InstantStringSerializer.class)
    @JsonDeserialize(using = InstantStringDeserializer.class)
    private Instant lastUpdatedZ;

    @JsonSerialize(using = LocalDateTimeStringSerializer.class)
    @JsonDeserialize(using = LocalDateTimeStringDeserializer.class)
    private LocalDateTime lastUpdatedLocal;

    private Double tempC;
    private String condition;
    private Integer conditionCode;
    private Double windKPH;
    private Integer windDegree;
    private Double precipitationMM;
    private Integer humidity;
    private Integer cloud;
    private Double feelsLikeC;
    private Double uv;

}
