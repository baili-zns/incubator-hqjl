package io.edurt.hqjl.querys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.aggregators.AggregatorFiltered;
import io.edurt.hqjl.aggregators.AggregatorThetaSketch;
import io.edurt.hqjl.base.granularity.StringGranularityEnum;
import io.edurt.hqjl.filters.IntervalFilter;
import io.edurt.hqjl.postaggregators.FieldAccessorPostAggregator;
import io.edurt.hqjl.postaggregators.ThetaSketchEstimate;
import io.edurt.hqjl.postaggregators.ThetaSketchSetOp;
import org.joda.time.Interval;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-03-17 11:37
 */
public class PostAggTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void ThetaTest() throws JsonProcessingException {
        Timeseries timeseries = Timeseries.builder()
                .dataSource("unique-test")
                .interval(Interval.parse("1970-01-01T00:00:00.000+08:00/2021-01-01T00:00:00.000+08:00"))
                .granularity(StringGranularityEnum.all)
                .aggregator(new AggregatorFiltered(new IntervalFilter("__time", Collections.singletonList(Interval.parse("2018-01-02/2018-01-03"))), new AggregatorThetaSketch("today", "unique")))
                .aggregator(new AggregatorFiltered(new IntervalFilter("__time", Collections.singletonList(Interval.parse("2018-01-01/2018-01-02"))), new AggregatorThetaSketch("history", "unique")))
                .postAggregator(new ThetaSketchEstimate("final_unique_users", new ThetaSketchSetOp("new_unique_animal", "NOT", Arrays.asList(new FieldAccessorPostAggregator("today"), new FieldAccessorPostAggregator("history")))))
                .build();
        System.out.println(mapper.writeValueAsString(timeseries));
    }

    @Test
    public void ThetaTest_build() throws JsonProcessingException {
        Timeseries timeseries = Timeseries.builder()
                .dataSource("unique-test")
                .interval(Interval.parse("1970-01-01T00:00:00.000+08:00/2021-01-01T00:00:00.000+08:00"))
                .granularity(StringGranularityEnum.all)
                .aggregator(AggregatorFiltered.builder()
                        .filter(IntervalFilter.builder()
                                .dimension("__time").interval(Interval.parse("2018-01-02/2018-01-03"))
                                .build())
                        .aggregator(
                                AggregatorThetaSketch.builder()
                                        .name("today")
                                        .fieldName("unique")
                                        .build())
                        .build())
                .aggregator(AggregatorFiltered.builder()
                        .filter(IntervalFilter.builder()
                                .dimension("__time").interval(Interval.parse("2018-01-01/2018-01-02"))
                                .build())
                        .aggregator(
                                AggregatorThetaSketch.builder()
                                        .name("history")
                                        .fieldName("unique")
                                        .build())
                        .build())
                .postAggregator(
                        ThetaSketchEstimate.builder()
                                .name("final_unique_users")
                                .field(
                                        ThetaSketchSetOp.builder()
                                                .name("new_unique_animal")
                                                .func("NOT")
                                                .field(FieldAccessorPostAggregator.builder().fieldName("today").build())
                                                .field(FieldAccessorPostAggregator.builder().fieldName("history").build())
                                                .build()
                                )
                                .build()
                )
                .build();
        System.out.println(mapper.writeValueAsString(timeseries));
    }
}