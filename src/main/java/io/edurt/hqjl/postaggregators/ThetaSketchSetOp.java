package io.edurt.hqjl.postaggregators;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/**
 * @program: incubator-hqjl
 * @description: thetaSketchSetOp
 * @author: zns
 * @create: 2020-03-17 11:25
 */
@Builder
@ToString
public class ThetaSketchSetOp implements PostAggregatorFactory{
    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "func")
    private final String func; //<UNION|INTERSECT|NOT>

    @Getter
    @JsonProperty(value = "fields")
    @Singular
    private final List<PostAggregatorFactory> fields;

    public ThetaSketchSetOp(String name, String func, List<PostAggregatorFactory> fields) {
        this.name = name;
        this.func = func;
        this.fields = fields;
    }
}