package com.demo.weatherapp.dao.impl;

import com.demo.weatherapp.dao.CountryDAO;
import com.demo.weatherapp.entity.location.Country;
import com.demo.weatherapp.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryDAOImpl implements CountryDAO {

    private final CountryRepository countryRepository;

    public CountryDAOImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country createCountry(String name, String countryCode) {
        return null;
//        return countryRepository.save(new Country(name));
    }



    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
