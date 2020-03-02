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
package io.edurt.hqjl.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.base.granularity.Granularity;
import io.edurt.hqjl.base.granularity.StringGranularity;
import org.joda.time.Interval;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * <p> QueryTypeTest </p>
 * <p> Description : QueryTypeTest </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 17:47 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
public class QueryTest {

    private ObjectMapper mapper = new ObjectMapper();
    private Query queryType;

    public static void build(Query query) {
        query.setDataSource("2R4NNDHSGD5R685GSSGN6GH66229F82N");
        query.setIntervals(new ArrayList<Interval>() {{
            add(new Interval("2020-01-01/2100-01-01"));
            add(new Interval("2020-01-01/2100-01-01"));
        }});
        query.setContext(null);
        Granularity granularity = new Granularity();
        granularity.setPeriod("P1D");
        granularity.setTimeZone("Asia/Shanghai");
        granularity.setType("period");
        query.setGranularity(new StringGranularity());
    }

    @Before
    public void before() {
        queryType = new Query();
    }

    @Test
    public void test() throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(queryType));
    }

    @Test
    public void testHasGranularity() throws JsonProcessingException {
        queryType.setGranularity(new StringGranularity());
        System.out.println(mapper.writeValueAsString(queryType));
    }

}
