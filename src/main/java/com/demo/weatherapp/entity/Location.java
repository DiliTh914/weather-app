package com.demo.weatherapp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {

    @Id
    private String id;

    private String name;

    private String region;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="time_zone_id", referencedColumnName = "id")
    private TimeZone timeZone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_id", referencedColumnName = "id")
    private Country country;

    public Location(String id, String name, String region, Country country, TimeZone timeZone) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.country = country;
        this.timeZone = timeZone;
    }
}
