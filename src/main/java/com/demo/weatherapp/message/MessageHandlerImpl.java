package com.demo.weatherapp.message;

import com.demo.weatherapp.config.ConfigProperties;
import com.demo.weatherapp.constant.MessageType;
import com.demo.weatherapp.dto.internal.CurrentWeatherDTO;
import com.demo.weatherapp.util.JsonUtil;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MessageHandlerImpl implements MessageHandler {


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Map<MessageType, String> msgTypes;

    public MessageHandlerImpl(KafkaTemplate<String, String> kafkaTemplate, ConfigProperties properties) {
        this.kafkaTemplate = kafkaTemplate;
        this.msgTypes = properties.getKafka().getTopics().stream()
                .collect(Collectors.toMap(ConfigProperties.KafkaProps.Topic::getIdentifier, ConfigProperties.KafkaProps.Topic::getName));
    }


    @Override
    public void sendCurrentWeatherMessage(CurrentWeatherDTO currentWeather) {
        String msg = JsonUtil.objectToJsonString(currentWeather);
        kafkaTemplate.send(msgTypes.get(MessageType.RAW_CURRENT_WEATHER_DATA), msg);
    }
}
