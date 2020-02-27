package io.edurt.hqjl.type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.aggregator.AggregatorCountFactory;
import io.edurt.hqjl.aggregator.AggregatorDoubleSumFactory;
import io.edurt.hqjl.aggregator.AggregatorLongSumFactory;
import io.edurt.hqjl.aggregator.post.ArithmeticPostAggregator;
import io.edurt.hqjl.aggregator.post.FieldAccessorPostAggregator;
import io.edurt.hqjl.base.granularity.EnumGranularity;
import io.edurt.hqjl.base.granularity.StringGranularity;
import io.edurt.hqjl.filter.AndFilter;
import io.edurt.hqjl.filter.Filter;
import io.edurt.hqjl.filter.OrFilter;
import io.edurt.hqjl.filter.SelectorFilter;
import org.joda.time.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-02-27 15:24
 */
public class GroupByTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGroupBy() throws JsonProcessingException {
        GroupBy groupBy = GroupBy.builder()
                .dataSource("sample_datasource")
                .granularity(new StringGranularity(EnumGranularity.year))
                .dimension("country").dimension("device")
                .filter(new AndFilter(
                        Arrays.asList(
                                new SelectorFilter("carrier", "AT&T"),
                                new OrFilter(Arrays.asList(
                                        new SelectorFilter("make", "Apple"),
                                        new SelectorFilter("make", "Samsung")
                                )
                                )
                        )))
                .aggregator(new AggregatorLongSumFactory("total_usage", "user_count"))
                .aggregator(new AggregatorDoubleSumFactory("data_transfer", "data_transfer"))
                .interval(Interval.parse("2012-01-01T00:00:00.000/2012-01-03T00:00:00.000").toString())
                .build();
        System.out.println(mapper.writeValueAsString(groupBy));
        System.out.println(groupBy);
    }

    @Test
    public void testGroupBy2() throws JsonProcessingException {
        GroupBy groupBy = GroupBy.builder()
                .dataSource("sample_datasource")
                .granularity(new StringGranularity(EnumGranularity.year))
                .dimension("country").dimension("device")
                .filter(
                        AndFilter.builder()
                                .field(new SelectorFilter("carrier", "AT&T"))
                                .field(
                                        OrFilter.builder().field(new SelectorFilter("make", "Apple"))
                                                .field(new SelectorFilter("make", "Samsung")).build()
                                ).build()
                )
                .aggregator(new AggregatorLongSumFactory("total_usage", "user_count"))
                .aggregator(new AggregatorDoubleSumFactory("data_transfer", "data_transfer"))
                .postAggregator(
                        ArithmeticPostAggregator.builder()
                                .name("avg_usage")
                                .fn("/")
                                .field(new FieldAccessorPostAggregator("data_transfer"))
                                .field(new FieldAccessorPostAggregator("total_usage")).build()
                )
                .interval(Interval.parse("2012-01-01T00:00:00.000/2012-01-03T00:00:00.000").toString())
                .build();
        System.out.println(mapper.writeValueAsString(groupBy));
        System.out.println(groupBy);
    }
}