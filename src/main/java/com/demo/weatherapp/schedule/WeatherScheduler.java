package com.demo.weatherapp.schedule;

import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;
import com.demo.weatherapp.message.MessageHandler;
import com.demo.weatherapp.entity.location.Location;
import com.demo.weatherapp.service.LocationService;
import com.demo.weatherapp.service.WeatherService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;

@Component
@EnableScheduling
public class WeatherScheduler {

    private final LocationService locationService;
    private final WeatherService weatherService;
    private final MessageHandler messageHandler;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public WeatherScheduler(LocationService locationService, WeatherService weatherService, MessageHandler messageHandler) {
        this.locationService = locationService;
        this.weatherService = weatherService;
        this.messageHandler = messageHandler;
    }

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void getCurrentWeather() {
        System.out.println("starting scheduler");
        long first = Instant.now().toEpochMilli();
        List<Location> locations = locationService.getAllLocations();

        CountDownLatch latch = new CountDownLatch(locations.size());

        locations.forEach(location -> executorService.submit(() -> sendHistoryEvent(location, latch)));

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("total time: " + (Instant.now().toEpochMilli() - first));
    }

    private void sendHistoryEvent(Location location, CountDownLatch latch) {
        CurrentWeatherDTO currentWeather = weatherService.getCurrentWeather(location.getName());
        messageHandler.sendCurrentWeatherMessage(currentWeather);
        latch.countDown();
    }




}
