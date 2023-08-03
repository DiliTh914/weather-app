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
@Table(name = "weather_history_atmosphere")
public class AtmosphereHistory {

    @Id
    private UUID id;
    private Integer humidity;
    private Integer cloud;
    private Double uv;

    public AtmosphereHistory(UUID id, Integer humidity, Integer cloud, Double uv) {
        this.id = id;
        this.humidity = humidity;
        this.cloud = cloud;
        this.uv = uv;
    }
}
