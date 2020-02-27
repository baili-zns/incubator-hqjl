package io.edurt.hqjl.type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.aggregator.AggregatorDoubleSumFactory;
import io.edurt.hqjl.aggregator.AggregatorLongSumFactory;
import io.edurt.hqjl.aggregator.post.ArithmeticPostAggregator;
import io.edurt.hqjl.aggregator.post.FieldAccessorPostAggregator;
import io.edurt.hqjl.base.granularity.EnumGranularity;
import io.edurt.hqjl.base.granularity.StringGranularity;
import io.edurt.hqjl.filter.AndFilter;
import io.edurt.hqjl.filter.InFilter;
import io.edurt.hqjl.filter.SearchFilter;
import io.edurt.hqjl.filter.SearchFilter.SearchQuery;
import io.edurt.hqjl.filter.SelectorFilter;
import lombok.ToString;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-02-27 16:40
 */
public class TopNTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void TopNTest() throws JsonProcessingException {
        TopN topN = TopN.builder()
                .dataSource("sample_data")
                .dimension("sample_dim")
                .threshold(5)
                .metric("count")
                .granularity(new StringGranularity(EnumGranularity.all))
                .filter(
                        AndFilter.builder()
                                .field(new SelectorFilter("dim1", "some_value"))
                                .field(new SelectorFilter("dim2", "some_other_val"))
                                .build()
                )
                .aggregator(new AggregatorLongSumFactory("count", "count"))
                .aggregator(new AggregatorDoubleSumFactory("some_metric", "some_metric"))
                .postAggregator(ArithmeticPostAggregator.builder()
                        .name("average")
                        .fn("/")
                        .field(new FieldAccessorPostAggregator("some_metric", "some_metric"))
                        .field(new FieldAccessorPostAggregator("count", "count")).build()
                )
                .interval("2013-08-31T00:00:00.000/2013-09-03T00:00:00.000")
                .build();
        System.out.println(mapper.writeValueAsString(topN));
    }

    @Test
    public void ScanTest() {

    }
}