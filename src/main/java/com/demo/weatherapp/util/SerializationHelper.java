package com.demo.weatherapp.util;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class SerializationHelper {

    private SerializationHelper() {
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static Instant getInstantFromLong(Long epochSecond) {
        return Instant.ofEpochSecond(epochSecond);
    }
}
