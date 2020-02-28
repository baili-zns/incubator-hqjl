package io.edurt.hqjl.base.searchqueryspec;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: If any part of a dimension value contains the value specified in this search query spec, a "match" occurs.
 * @author: zns
 * @create: 2020-02-28 14:12
 */
@ToString
@Builder
public class Contains implements SearchQueryFactory{

    @Getter
    @Builder.Default
    @JsonProperty(value = "case_sensitive")
    private Boolean case_sensitive = true; // 持续时间

    @Getter
    @JsonProperty(value = "value")
    private final String value; // 持续时间

    @JsonCreator
    public Contains(@JsonProperty("value") final String value) {
        this.case_sensitive = true;
        this.value = value;
    }

    @JsonCreator
    public Contains(@JsonProperty(value = "case_sensitive") Boolean case_sensitive,
            @JsonProperty("value") final String value) {
        this.case_sensitive = case_sensitive;
        this.value = value;
    }
}