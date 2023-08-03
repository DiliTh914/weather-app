package com.demo.weatherapp.entity.weather;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "weather_history_temperature")
public class TemperatureHistory {

    @Id
    private UUID id;

    @Column(name = "temp_c")
    private Double tempC;

    @Column(name = "feels_like_c")
    private Double feelsLikeC;

    public TemperatureHistory(UUID id, Double tempC, Double feelsLikeC) {
        this.id = id;
        this.tempC = tempC;
        this.feelsLikeC = feelsLikeC;
    }
}
