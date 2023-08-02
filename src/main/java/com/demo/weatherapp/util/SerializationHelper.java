package com.demo.weatherapp.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SerializationHelper {

    private SerializationHelper() {
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static Instant getInstantFromEpochSec(Long epochSecond) {
        return Instant.ofEpochSecond(epochSecond);
    }

    public static LocalDateTime getLocalDateTimeFromString(String text) {
        return LocalDateTime.parse(text, formatter);
    }

    public static Long getEpochSecFromInstant(Instant value) {
        return value.getEpochSecond();
    }

    public static String getInstantString(Instant value) {
        return value.toString();
    }

    public static Instant getInstantFromString(String text) {
        return Instant.parse(text);
    }

    public static String getLocalDateTimeString(LocalDateTime localDateTime) {
        return formatter.format(localDateTime);
    }
}
