package com.demo.weatherapp.serializer.gson;


import com.demo.weatherapp.util.SerializationHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.Instant;

public class InstantStringSerializer implements JsonSerializer<Instant> {

    @Override
    public JsonElement serialize(Instant instant, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(SerializationHelper.getInstantString(instant));
    }
}
