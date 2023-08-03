package com.demo.weatherapp.entity.location;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "country")
public class Country {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
    private Set<Location> locations = new HashSet<>();

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
