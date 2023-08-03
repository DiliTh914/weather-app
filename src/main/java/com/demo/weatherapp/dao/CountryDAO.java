package com.demo.weatherapp.dao;

import com.demo.weatherapp.entity.Country;

import java.util.List;

public interface CountryDAO {

    Country createCountry(String name, String countryCode);

    List<Country> getAllCountries();
}
