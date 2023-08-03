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
@Table(name = "weather_history_precipitation ")
public class PrecipitationHistory {

    @Id
    private UUID id;

    @Column(name = "precipitation_mm")
    private Double precipitationMM;

    public PrecipitationHistory(UUID id, Double precipitationMM) {
        this.id = id;
        this.precipitationMM = precipitationMM;
    }
}
