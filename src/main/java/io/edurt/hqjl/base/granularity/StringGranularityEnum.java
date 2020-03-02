package io.edurt.hqjl.base.granularity;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

import java.io.IOException;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-02-26 15:48
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.WRAPPER_OBJECT)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NONE,include = JsonTypeInfo.As.WRAPPER_OBJECT)
//@JsonSubTypes(value = {
//        @JsonSubTypes.Type(name = "type", value = StringGranularityEnum.class),
//})
public enum StringGranularityEnum implements GranularityFactory
        , JsonSerializable
{
    all, none, second, minute, fifteen_minute, thirty_minute, hour, day, week, month, quarter, year;

//    all("all"),
//    none("none"),
//    second("second"),
//    minute("minute"),
//    fifteen_minute("fifteen_minute"),
//    thirty_minute("thirty_minute"),
//    hour("hour"),
//    day("day"),
//    week("week"),
//    month("month"),
//    quarter("quarter"),
//    year("year");

//    @Getter
//    @JsonProperty(value = "graunlarity")
//    private String graunlarity;
//
//    @JsonCreator
//    StringGranularityEnum() {
//        this.graunlarity = StringGranularityEnum.valueOf("all").name();
//    }
//
//    @JsonCreator
//    StringGranularityEnum(String graunlarity) {
//        this.graunlarity = graunlarity;
//    }

    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(this.name());
    }

    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.writeString(this.name());
    }
}