package com.demo.weatherapp.config;

import com.demo.weatherapp.constant.MessageType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app", ignoreInvalidFields = true)
public class ConfigProperties {

    private WeatherAPIProps weatherApi;
    private KafkaProps kafka;

    @Getter
    @Setter
    public static class WeatherAPIProps {
        private String baseUrl;
        private String accessKey;
    }

    @Getter
    @Setter
    public static class KafkaProps {
        private Topic topics;

        @Getter
        @Setter
        public static class Topic {
            private String rawCurrentWeatherData;

        }



    }
}
