package com.demo.weatherapp.serializer.gson;


import com.demo.weatherapp.util.SerializationHelper;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.Instant;

public class InstantStringDeserializer implements JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return SerializationHelper.getInstantFromString(jsonElement.getAsString());
    }
}
