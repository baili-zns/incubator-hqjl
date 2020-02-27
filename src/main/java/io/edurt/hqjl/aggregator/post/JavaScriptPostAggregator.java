package io.edurt.hqjl.aggregator.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/**
 * @program: incubator-hqjl
 * @description: Field accessor
 * @author: zns
 * @create: 2020-02-27 16:12
 */
@ToString
@Builder
public class JavaScriptPostAggregator implements PostAggregatorFactory{
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @Singular
    @JsonProperty(value = "fieldNames")
    private final List<String> fieldNames;

    @Getter
    @JsonProperty(value = "function")
    private final String function;

    @JsonCreator
    public JavaScriptPostAggregator(String name, List<String> fieldNames, String function) {
        this.name = name;
        this.fieldNames = fieldNames;
        this.function = function;
    }
}