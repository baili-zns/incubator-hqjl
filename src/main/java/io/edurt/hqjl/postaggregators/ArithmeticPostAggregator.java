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
public class ArithmeticPostAggregator implements PostAggregatorFactory {
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "fn")
    private final String fn;

    @Getter
    @Singular
    @JsonProperty(value = "fields")
    private final List<PostAggregatorFactory> fields;

    @Getter
    @JsonProperty(value = "ordering")
    private String ordering;


    @JsonCreator
    public ArithmeticPostAggregator(@JsonProperty("name") String name, String fn, List<PostAggregatorFactory> fields) {
        this.name = name;
        this.fn = fn;
        this.fields = fields;
    }

    @JsonCreator
    public ArithmeticPostAggregator(@JsonProperty("name") String name, String fn, List<PostAggregatorFactory> fields, String ordering) {
        this.name = name;
        this.fn = fn;
        this.fields = fields;
        this.ordering = ordering;
    }
}