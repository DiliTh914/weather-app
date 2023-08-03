package com.demo.weatherapp.util;

import com.demo.weatherapp.serializer.gson.InstantStringDeserializer;
import com.demo.weatherapp.serializer.gson.InstantStringSerializer;
import com.demo.weatherapp.serializer.gson.LocalDateTimeDeserializer;
import com.demo.weatherapp.serializer.gson.LocalDateTimeSerializer;
import com.google.gson.*;

import java.time.Instant;
import java.time.LocalDateTime;

public class JsonUtil {

    private JsonUtil() {
    }

    private static final Gson gson  = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
            .registerTypeAdapter(Instant.class, new InstantStringSerializer())
            .registerTypeAdapter(Instant.class, new InstantStringDeserializer())
            .create();

    public static String objectToJsonString(Object object) {
        return gson.toJson(object);
    }

    public static <T> T jsonStringToObject(String value, Class<T> returnType) {
        return gson.fromJson(value,returnType);
    }
}
