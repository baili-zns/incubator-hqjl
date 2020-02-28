package io.edurt.hqjl.base.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: If any part of a dimension value contains the value specified in this search query spec, regardless of case, a "match" occurs.
 * @author: zns
 * @create: 2020-02-28 14:12
 */
@ToString
@Builder
public class InsensitiveContains implements SearchQueryFactory{
    @Getter
    @JsonProperty(value = "value")
    private final String value; // 持续时间

    @JsonCreator
    public InsensitiveContains(@JsonProperty("value") final String value) {
        this.value = value;
    }
}