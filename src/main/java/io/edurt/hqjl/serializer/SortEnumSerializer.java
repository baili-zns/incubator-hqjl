package io.edurt.hqjl.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import io.edurt.hqjl.base.sort.SortEnum;

import java.io.IOException;

import static com.fasterxml.jackson.core.JsonToken.START_OBJECT;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-03 16:18
 */

public class SortEnumSerializer extends JsonSerializer<Enum>{

    @Override
    public void serialize(Enum anEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(anEnum.name());
    }

    @Override
    public void serializeWithType(Enum value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
//        WritableTypeId typeId = typeSer.typeId(value, START_OBJECT);
//        typeSer.writeTypePrefix(gen, typeId);
//        serialize(value, gen, provider); // call your customized serialize method
//        typeSer.writeTypeSuffix(gen, typeId);

//        typeSer.writeTypePrefixForObject(value, gen);
        serialize(value, gen, provider); // call your customized serialize method
//        typeSer.writeTypeSuffixForObject(value, gen);
    }
}