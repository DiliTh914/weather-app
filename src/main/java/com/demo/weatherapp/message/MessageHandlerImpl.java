package com.demo.weatherapp.message;

import com.demo.weatherapp.config.ConfigProperties;
import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;
import com.demo.weatherapp.service.WeatherService;
import com.demo.weatherapp.util.JsonUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageHandlerImpl implements MessageHandler {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ConfigProperties properties;
    private final WeatherService weatherService;

    public MessageHandlerImpl(KafkaTemplate<String, String> kafkaTemplate, ConfigProperties properties, WeatherService weatherService) {
        this.kafkaTemplate = kafkaTemplate;
        this.properties = properties;
        this.weatherService = weatherService;
    }


    @Override
    public void sendCurrentWeatherMessage(CurrentWeatherDTO currentWeather) {
        String msg = JsonUtil.objectToJsonString(currentWeather);
        kafkaTemplate.send(properties.getKafka().getTopics().getRawCurrentWeatherData(), msg);
    }

    @KafkaListener(topics = "${app.kafka.topics.rawCurrentWeatherData}", groupId = "group_id")
    public void consumeCurrentWeatherMessage(ConsumerRecord<String, String> payload){
        System.out.println("consumer: "+payload.key());
        CurrentWeatherDTO currentWeatherDTO = JsonUtil.jsonStringToObject(payload.value(), CurrentWeatherDTO.class);
        weatherService.saveWeatherHistory(currentWeatherDTO);
    }
}
