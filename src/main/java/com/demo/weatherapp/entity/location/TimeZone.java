package com.demo.weatherapp.entity.location;

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
@Table(name = "time_zone")
public class TimeZone {

    @Id
    private String id;

    private String offSet;

    public TimeZone(String id, String offSet) {
        this.id = id;
        this.offSet = offSet;
    }
}
