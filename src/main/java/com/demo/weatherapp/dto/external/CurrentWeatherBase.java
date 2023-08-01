package com.demo.weatherapp.dto.external;

import com.demo.weatherapp.serializer.InstantDeserializer;
import com.demo.weatherapp.serializer.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class CurrentWeatherBase {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonProperty("last_updated")
    private LocalDateTime lastUpdatedLocal;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonProperty("last_updated_epoch")
    private Instant lastUpdatedEpoch;

    @JsonProperty("temp_c")
    private Double tempC;

    private Condition condition;

    @JsonProperty("wind_kph")
    private Double windKPH;

    @JsonProperty("wind_degree")
    private Integer windDegree;

    @JsonProperty("precip_mm")
    private Double precipitationMM;

    private Integer humidity;

    private Integer cloud;

    @JsonProperty("feelslike_c")
    private Double feelsLikeC;

    private Double uv;
}
