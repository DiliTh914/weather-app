package com.demo.weatherapp.dao.impl;

import com.demo.weatherapp.dao.CountryDAO;
import com.demo.weatherapp.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryDAOImpl implements CountryDAO {

    private final CountryRepository countryRepository;

    public CountryDAOImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
}
