package io.edurt.hqjl.postaggregators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/**
 * @program: incubator-hqjl
 * @description: Arithmetic
 * @author: zns
 * @create: 2020-02-27 15:45
 */
@Builder
@ToString
public class LongLeastPostAggregator implements PostAggregatorFactory {
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @Singular
    @JsonProperty(value = "fields")
    private final List<PostAggregatorFactory> fields;


    @JsonCreator
    public LongLeastPostAggregator(@JsonProperty("name") String name, List<PostAggregatorFactory> fields) {
        this.name = name;
        this.fields = fields;
    }
}