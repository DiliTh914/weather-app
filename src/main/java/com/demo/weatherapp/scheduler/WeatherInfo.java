package com.demo.weatherapp.scheduler;

import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.model.Location;
import com.demo.weatherapp.service.LocationService;
import com.demo.weatherapp.service.WeatherService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
public class WeatherInfo {

    private final LocationService locationService;
    private final WeatherService weatherService;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public WeatherInfo(LocationService locationService, WeatherService weatherService) {
        this.locationService = locationService;
        this.weatherService = weatherService;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void currentWeather() {
        System.out.println("starting scheduler");
        long first = Instant.now().toEpochMilli();
        List<Location> locations = locationService.getAllLocations();

        CountDownLatch latch = new CountDownLatch(locations.size());

        locations.forEach(location -> executorService.submit(() -> addHistoryEvent(location, latch)));

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total time: " + (Instant.now().toEpochMilli() - first));
    }

    private void addHistoryEvent(Location location, CountDownLatch latch) {
        CurrentWeather currentWeather = weatherService.getCurrentWeather(location.getName());

        latch.countDown();
    }


}
