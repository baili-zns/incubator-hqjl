package io.edurt.hqjl.base.granularity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.NoArgsConstructor;

import java.io.IOException;

/**
 * @program: incubator-hqjl
 * @description: StringGranularityJsonSerializer
 * @author: zns
 * @create: 2020-02-26 15:52
 */
@Deprecated
public class StringGranularitySerializer extends JsonSerializer<StringGranularity> {

//    public StringGranularitySerializer(Class<StringGranularity> t) {
//        super(t);
//    }

    @Override
    public void serialize(StringGranularity stringGranularity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(stringGranularity.toString());
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeString(stringGranularity.toString());
//        jsonGenerator.writeEndObject();
    }


}