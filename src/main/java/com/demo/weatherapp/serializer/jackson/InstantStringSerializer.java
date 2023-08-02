package com.demo.weatherapp.serializer.jackson;

import com.demo.weatherapp.util.SerializationHelper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;

public class InstantStringSerializer extends JsonSerializer<Instant> {

    @Override
    public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String text = SerializationHelper.getInstantString(value);
        gen.writeString(text);
    }
}
