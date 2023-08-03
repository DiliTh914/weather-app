package com.demo.weatherapp.entity.weather;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "weather_history")
public class WeatherHistory {

    @Id
    private UUID id;
    private String locationId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="condition_id", referencedColumnName = "id")
    private WeatherCondition condition;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private WindHistory windHistory;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private TemperatureHistory temperatureHistory;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AtmosphereHistory atmosphereHistory;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PrecipitationHistory precipitationHistory;

    private Instant lastUpdatedZ;
    private LocalDateTime lastUpdatedLocal;

    public WeatherHistory(UUID id, String locationId, WeatherCondition condition, WindHistory windHistory, TemperatureHistory temperatureHistory,
                          AtmosphereHistory atmosphereHistory, PrecipitationHistory precipitationHistory, Instant lastUpdatedZ, LocalDateTime lastUpdatedLocal) {
        this.id = id;
        this.locationId = locationId;
        this.condition = condition;
        this.windHistory = windHistory;
        this.temperatureHistory = temperatureHistory;
        this.atmosphereHistory = atmosphereHistory;
        this.precipitationHistory = precipitationHistory;
        this.lastUpdatedZ = lastUpdatedZ;
        this.lastUpdatedLocal = lastUpdatedLocal;
    }

}
