package io.edurt.hqjl.postaggregators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: Field accessor
 * @author: zns
 * @create: 2020-02-27 16:12
 */
@Builder
@ToString
public class FieldAccessorPostAggregator implements PostAggregatorFactory{
    @Getter
    @JsonProperty(value = "name")
    private String name;

    @Getter
    @JsonProperty(value = "fieldName")
    private final String fieldName;

    @JsonCreator
    public FieldAccessorPostAggregator(String fieldName) {
        this.fieldName = fieldName;
    }

    @JsonCreator
    public FieldAccessorPostAggregator(String name, String fieldName) {
        this.name = name;
        this.fieldName = fieldName;
    }
}