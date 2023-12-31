package com.demo.weatherapp.serializer.gson;

import com.demo.weatherapp.util.SerializationHelper;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return SerializationHelper.getLocalDateTimeFromString(jsonElement.getAsString());
    }
}
