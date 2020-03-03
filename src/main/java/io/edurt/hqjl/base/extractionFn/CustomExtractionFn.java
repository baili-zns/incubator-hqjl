package io.edurt.hqjl.base.extractionFn;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.Builder;
import lombok.Singular;
import lombok.ToString;

import java.io.IOException;
import java.util.Map;

/**
 * @program: incubator-hqjl
 * @description: 自定义的ExtractionFn，随便放入键值对
 * @author: zns
 * @create: 2020-03-03 15:40
 */
@ToString
@Builder
public class CustomExtractionFn implements ExtractionFn, JsonSerializable {
    @Singular
    @JsonProperty(value = "contents")
    private Map<String, Object> contents;

    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(this.contents);
    }

    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.writeObject(this.contents);
    }
}