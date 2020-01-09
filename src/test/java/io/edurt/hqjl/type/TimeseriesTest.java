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
package io.edurt.hqjl.type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.aggregator.AggregatorFactory;
import io.edurt.hqjl.aggregator.AggregatorLongSumFactory;
import io.edurt.hqjl.base.Granularity;
import io.edurt.hqjl.base.QueryTest;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void test1() throws JsonProcessingException {
        timeseries = new Timeseries(
                "2R4NNDHSGD5R685GSSGN6GH66229F82N",
                Arrays.asList("2020-01-01T00:00:00.000+08:00", "2020-02-01T00:00:00.000+08:00"),
                null,
                new Granularity(),
                null,
                null,
                null
        );
        QueryTest.build(timeseries);
        System.out.println(mapper.writeValueAsString(timeseries));
    }

    @Test
    public void testAggregator() throws JsonProcessingException {
        AggregatorFactory longSumFactory = new AggregatorLongSumFactory("count-cj_home_tab_visit", "count");
        timeseries = new Timeseries(
                "2R4NNDHSGD5R685GSSGN6GH66229F82N",
                Arrays.asList("2020-01-01T00:00:00.000+08:00", "2020-02-01T00:00:00.000+08:00"),
                null,
                new Granularity(),
                Arrays.asList(longSumFactory),
                null,
                null
        );
        QueryTest.build(timeseries);
        System.out.println(mapper.writeValueAsString(timeseries));
    }

}
