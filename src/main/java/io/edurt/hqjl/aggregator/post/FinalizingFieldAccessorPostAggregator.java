package io.edurt.hqjl.aggregator.post;

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
public class FinalizingFieldAccessorPostAggregator implements PostAggregatorFactory{
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "fieldName")
    private final String fieldName;

    @JsonCreator
    public FinalizingFieldAccessorPostAggregator(String name, String fieldName) {
        this.name = name;
        this.fieldName = fieldName;
    }
}