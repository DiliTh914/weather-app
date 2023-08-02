package com.demo.weatherapp.serializer.jackson;

import com.demo.weatherapp.util.SerializationHelper;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

public class InstantEpochSecDeserializer extends JsonDeserializer<Instant> {
    @Override
    public Instant deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return SerializationHelper.getInstantFromEpochSec(p.getLongValue());
    }
}
