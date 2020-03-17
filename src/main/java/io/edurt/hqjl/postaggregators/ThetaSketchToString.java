package io.edurt.hqjl.postaggregators;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: thetaSketchToString
 * @author: zns
 * @create: 2020-03-17 11:34
 */
@Builder
@ToString
@AllArgsConstructor
public class ThetaSketchToString implements PostAggregatorFactory{
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "field")
    private final PostAggregatorFactory field;
}