package io.edurt.hqjl.base.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @program: incubator-hqjl
 * @description: If any part of a dimension value contains all of the values specified in this search query spec, regardless of case by default, a "match" occurs.
 * @author: zns
 * @create: 2020-02-28 14:12
 */
@ToString
@Builder
public class Fragment implements SearchQueryFactory{

    @Getter
    @Builder.Default
    @JsonProperty(value = "case_sensitive")
    private Boolean case_sensitive = false; // 持续时间

    @Getter
    @JsonProperty(value = "values")
    private final List<String> values; // 持续时间

    @JsonCreator
    public Fragment(@JsonProperty("values") final List<String> values) {
        this.values = values;
    }

    @JsonCreator
    public Fragment(@JsonProperty("case_sensitive") Boolean case_sensitive,
            @JsonProperty("values") final List<String> values) {
        this.case_sensitive = case_sensitive;
        this.values = values;
    }
}