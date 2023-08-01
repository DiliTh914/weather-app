package com.demo.weatherapp.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
public class ConfigProperties {

    private WeatherAPIProps weatherApi;


    @Getter
    @Setter
    public static class WeatherAPIProps {
        private String baseUrl;
        private String accessKey;
    }
}
