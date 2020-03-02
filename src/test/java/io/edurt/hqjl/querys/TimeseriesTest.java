/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.edurt.hqjl.querys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.aggregators.AggregatorCountFactory;
import io.edurt.hqjl.base.*;
import io.edurt.hqjl.base.granularity.*;
import io.edurt.hqjl.filters.AndFilter;
import io.edurt.hqjl.filters.SelectorFilter;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;



/**
 * <p> TimeseriesTest </p>
 * <p> Description : TimeseriesTest </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 18:07 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
public class TimeseriesTest {

    private ObjectMapper mapper = new ObjectMapper();
    private Timeseries timeseries;

    @Before
    public void before() {
        timeseries = new Timeseries();
    }

    @Test
    public void test() throws JsonProcessingException {
        QueryTest.build(timeseries);
        System.out.println(mapper.writeValueAsString(timeseries));
    }

//    @Test
//    public void test1() throws JsonProcessingException {
//        timeseries = new Timeseries(
//                "2R4NNDHSGD5R685GSSGN6GH66229F82N",
//                Arrays.asList("2020-01-01T00:00:00.000+08:00", "2020-02-01T00:00:00.000+08:00"),
//                null,
//                new StringGranularity(),
//                null,
//                null,
//                null
//        );
//        QueryTest.build(timeseries);
//        System.out.println(mapper.writeValueAsString(timeseries));
//    }
//
//    @Test
//    public void testAggregator() throws JsonProcessingException {
//        AggregatorFactory longSumFactory = new AggregatorLongSumFactory("count-cj_home_tab_visit", "count");
//        timeseries = new Timeseries(
//                "2R4NNDHSGD5R685GSSGN6GH66229F82N",
//                Arrays.asList("2020-01-01T00:00:00.000+08:00", "2020-02-01T00:00:00.000+08:00"),
//                null,
//                new StringGranularity(EnumGranularity.all),
//                Arrays.asList(longSumFactory),
//                null,
//                null
//        );
//        QueryTest.build(timeseries);
//        System.out.println(mapper.writeValueAsString(timeseries));
//        System.out.println(mapper);
//
//    }

    @Test
    public void testAlarm() throws JsonProcessingException {
        Timeseries timeseries = new Timeseries(
                "JcbkData",
                new ArrayList<Interval>() {{
                    add(new Interval("2020-01-01/2100-01-01"));
                }},
                new AndFilter(Arrays.asList((new SelectorFilter("alarm", "true")))),
                new StringGranularity(StringGranularityEnum.year),
//                new DurationGranularity("31622400000"),
//                new PeriodGranularity("P1Y","Asia/Shanghai",""),
                Arrays.asList(new AggregatorCountFactory("count")),
                null,
                null
        );
        System.out.println(mapper.writeValueAsString(timeseries));
        System.out.println(timeseries);
    }

    @Test
    public void testBuild() throws JsonProcessingException {
        Timeseries timeseries = Timeseries.builder()
                .dataSource("JcbkData")
                .interval(new Interval("2020-01-01/2100-01-01"))
//                .intervals(new ArrayList<String>() {{
//                    add(new Interval("2020-01-01/2100-01-01").toString());
//                }})
//                .filter(new AndFilter((new SelectorFilter("alarm", "true"))))
//                .filter(new AndFilter(Arrays.asList((new SelectorFilter("alarm", "true")))))
                .granularity(new StringGranularity(StringGranularityEnum.year))
                .aggregator(new AggregatorCountFactory("count"))
                .build();
        System.out.println(mapper.writeValueAsString(timeseries));
        System.out.println(timeseries);
    }

    @Test
    public void test_StringGranularity() {
        StringGranularity stringGranularity = new StringGranularity();
        System.out.println(stringGranularity);
        PeriodGranularity periodGranularity = new PeriodGranularity("P1Y","Asia/Shanghai","");
        System.out.println(periodGranularity.toString());
    }

    @Test
    public void JodaTimeTest() {
        String datestr1 = "2016-06-07T14:08:09.235+08:00"; //ISO8601
        String datestr2 = "2016-06-07 14:08:09"; //Without Millis
        String datestr3 = "2016-06-07 14:08:09.235"; //With Millis
        String datestr4 = "2016-06-07"; //ISO8601


        //Joda Time
        Date date0 = new DateTime(datestr4).toDate();
        System.out.println(new DateTime(datestr4).withZone(DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Shanghai"))).toString());
        System.out.println(new DateTime(1582770878548L).toString());
        System.out.println(DateTime.parse(datestr4));
        Date date1 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ").parseDateTime(datestr1).toDate();
        Date date2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime(datestr2).toDate();
        Date date3 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS").parseDateTime(datestr3).toDate();
        Interval interval1 = new Interval(0,1582782215533L);
        Interval interval2 = new Interval("1970/2000");
        Interval interval3 = new Interval(new DateTime("1970"), new DateTime("2100"));
        System.out.println(interval1);
        System.out.println(interval2.toString());
        System.out.println(interval3.toString());
    }


}
