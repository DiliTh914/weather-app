package com.demo.weatherapp.scheduler;

import com.demo.weatherapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class Weather {

    @Autowired
    CountryRepository countryRepository;

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void currentWeather() {
        System.out.println(Instant.now());
    }

}
