package com.demo.weatherapp.entity.weather;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "weather_condition")
public class WeatherCondition {

    @Id
    private Integer id;

    private String description;

    public WeatherCondition(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
}
