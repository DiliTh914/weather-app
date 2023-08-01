package com.demo.weatherapp.repository;

import com.demo.weatherapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    boolean existsCountryByCountryCode(String countryCode);
}
