package io.edurt.hqjl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.Interval;

import java.io.IOException;
import java.util.List;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-02 13:59
 */
public class IntervalsSerializer extends JsonSerializer<List<Interval>> {
    @Override
    public void serialize(List<Interval> intervals, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray();
        for (Interval interval :
                intervals) {
            jsonGenerator.writeString(interval.toString());
        }
        jsonGenerator.writeEndArray();
    }
}