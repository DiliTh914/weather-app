package com.demo.weatherapp.serializer.jackson;

import com.demo.weatherapp.util.SerializationHelper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeStringSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String text = SerializationHelper.getLocalDateTimeString(localDateTime);
        gen.writeString(text);
    }
}
