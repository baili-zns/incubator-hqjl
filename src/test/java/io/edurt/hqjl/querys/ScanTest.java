package io.edurt.hqjl.querys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.base.searchqueryspec.Contains;
import io.edurt.hqjl.filters.*;
import org.joda.time.Interval;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-02 14:19
 */
public class ScanTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void ScanTest() throws JsonProcessingException {
        Scan scan = Scan.builder()
                .dataSource("JcbkData")
                .resultFormat("list")
                .columns(Arrays.asList("__time",
                        "plateNo",
                        "plateType",
                        "bayName",
                        "tagStartTimeTop",
                        "direction",
                        "tagControlRange",
                        "tagControlType"))
                .interval(Interval.parse("1970-01-01/2022-01-02"))
                .order(Scan.ScanOrder.none)
                .batchSize(20480)
                .limit(100)
                .filter(AndFilter.builder()
                        .field(IntervalFilter.builder().dimension("tagStartTimeTop").interval("2014-10-01/2024-10-07").build())
                        .field(SelectorFilter.builder().dimension("plateType").value("01").build())
                        .field(new InFilter("direction", Arrays.asList("1", "2", "3")))
                        .field(SearchFilter.builder().dimension("tagControlRange").query(Contains.builder().value("滨湖区").build()).build())
                        .field(new InFilter("tagControlType", Arrays.asList("01", "02", "03")))
                        .field(SearchFilter.builder().dimension("plateNo").query(new Contains("苏A12345")).build())
                        .build())
                .build();

        System.out.println(mapper.writeValueAsString(scan));
    }
}