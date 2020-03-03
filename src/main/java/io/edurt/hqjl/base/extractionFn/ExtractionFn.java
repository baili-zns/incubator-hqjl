package io.edurt.hqjl.base.extractionFn;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.edurt.hqjl.filters.AndFilter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "timeFormat", value = TimeFormatFn.class),
        @JsonSubTypes.Type(name = "customFn", value = CustomExtractionFn.class),
})
public interface ExtractionFn {
}
