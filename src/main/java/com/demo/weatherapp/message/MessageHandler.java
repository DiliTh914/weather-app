package com.demo.weatherapp.message;

import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;

public interface MessageHandler {

    void sendCurrentWeatherMessage(CurrentWeatherDTO currentWeather);

}
