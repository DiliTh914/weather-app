package com.demo.weatherapp.dao;

import com.demo.weatherapp.model.Country;

public interface CountryDAO {

    Country createCountry(String name, String countryCode);

    boolean isCountryExists(String countryCode);
}
