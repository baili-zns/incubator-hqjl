package io.edurt.hqjl.aggregators;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edurt.hqjl.filters.Filter;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: filtered
 * @author: zns
 * @create: 2020-03-17 11:06
 */
@ToString
@Builder
public class AggregatorFiltered implements AggregatorFactory {
    @Getter
    @JsonProperty(value = "filter")
    private final Filter filter;

    @Getter
    @JsonProperty(value = "aggregator")
    private final AggregatorFactory aggregator;

    public AggregatorFiltered(@JsonProperty("filter") Filter filter, @JsonProperty("aggregator") AggregatorFactory aggregator) {
        this.filter = filter;
        this.aggregator = aggregator;
    }
}