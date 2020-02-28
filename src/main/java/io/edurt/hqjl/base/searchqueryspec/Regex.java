package io.edurt.hqjl.base.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: If any part of a dimension value contains the pattern specified in this search query spec, a "match" occurs.
 * @author: zns
 * @create: 2020-02-28 14:12
 */
@ToString
@Builder
public class Regex implements SearchQueryFactory {

    @Getter
    @JsonProperty(value = "pattern")
    private final String pattern; // 持续时间

    @JsonCreator
    public Regex(@JsonProperty("pattern") final String pattern) {
        this.pattern = pattern;
    }


}