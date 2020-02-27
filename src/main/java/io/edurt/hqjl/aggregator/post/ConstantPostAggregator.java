package io.edurt.hqjl.aggregator.post;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: Constant post-aggregator
 * @author: zns
 * @create: 2020-02-27 16:15
 */
@ToString
@Builder
public class ConstantPostAggregator  implements PostAggregatorFactory{
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "value")
    private final String value;

    @JsonCreator
    public ConstantPostAggregator(String name, String value) {
        this.name = name;
        this.value = value;
    }
}