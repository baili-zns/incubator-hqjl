package io.edurt.hqjl.postaggregators;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: thetaSketchEstimate
 * @author: zns
 * @create: 2020-03-17 11:21
 */
@Builder
@ToString
public class ThetaSketchEstimate implements PostAggregatorFactory {

    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "field")
    private final PostAggregatorFactory field;


    public ThetaSketchEstimate(@JsonProperty("name") String name, @JsonProperty("field") PostAggregatorFactory field) {
        this.name = name;
        this.field = field;
    }
}