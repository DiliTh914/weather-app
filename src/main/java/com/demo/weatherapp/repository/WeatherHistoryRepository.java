package com.demo.weatherapp.repository;

import com.demo.weatherapp.entity.weather.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Integer> {
}
