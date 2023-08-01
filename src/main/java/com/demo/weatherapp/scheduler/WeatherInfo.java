package com.demo.weatherapp.scheduler;

import com.demo.weatherapp.dto.external.CurrentWeather;
import com.demo.weatherapp.model.Location;
import com.demo.weatherapp.service.LocationService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Component
@EnableScheduling
public class WeatherInfo {

    private final LocationService locationService;

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    public WeatherInfo(LocationService locationService) {
        this.locationService = locationService;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void currentWeather() {
        System.out.println("starting scheduler");
        long first = Instant.now().toEpochMilli();
        List<Location> locations = locationService.getAllLocations();

        CountDownLatch latch = new CountDownLatch(locations.size());

        locations.forEach(location -> {

            executorService.submit(() -> {

                try {
                    test(location, latch);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });

        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total time: " + (Instant.now().toEpochMilli() - first));
    }

    private void test(Location location, CountDownLatch latch) throws Exception {
        System.out.println("start "+location.getLocationCode());
        Thread.sleep(5000+ new Random().nextInt(2)*1000);
        System.out.println("end "+location.getLocationCode());
        latch.countDown();
    }


}
