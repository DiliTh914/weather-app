package com.demo.weatherapp.entity.weather;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "weather_history_wind")
public class WindHistory {

    @Id
    private UUID id;

    private Double windKPH;
    private Integer windDegree;

    public WindHistory(UUID id, Double windKPH, Integer windDegree) {
        this.id = id;
        this.windKPH = windKPH;
        this.windDegree = windDegree;
    }
}
