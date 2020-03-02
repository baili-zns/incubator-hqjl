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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edurt.hqjl.aggregators.AggregatorFactory;
import io.edurt.hqjl.postaggregators.PostAggregatorFactory;
import io.edurt.hqjl.base.granularity.GranularityFactory;
import io.edurt.hqjl.base.Query;
import io.edurt.hqjl.filters.Filter;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.joda.time.Interval;

import java.util.List;
import java.util.Map;

/**
 * <p> Timeseries </p>
 * <p> Description : Timeseries </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 17:39 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@Data
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Timeseries extends Query {

    @Builder.Default
    @JsonProperty(value = "descending")
    private Boolean descending = false; // 降序,默认false为升序

//    @Builder.Default
    @Singular
    @JsonProperty(value = "aggregations")
    private List<AggregatorFactory> aggregators; // 聚集体

//    @Builder.Default
    @Singular
    @JsonProperty(value = "postAggregations")
    private List<PostAggregatorFactory> postAggregators; // 后续聚集体

    public Timeseries(String dataSource,
                      List<Interval> intervals,
                      Filter filter,
                      GranularityFactory granularityFactory,
                      List<AggregatorFactory> aggregator,
                      List<PostAggregatorFactory> postAggregator,
                      Map<String, Object> context) {
        super(dataSource, intervals, context, granularityFactory, filter);
//        this.filter = filter;
//        this.granularity = granularityFactory;
        this.aggregators = aggregator;
        this.postAggregators = postAggregator;
//        this.dataSource = dataSource;
//        this.intervals = intervals;
//        this.context = context;
    }

    public Timeseries(String dataSource,
                      List<Interval> intervals,
                      Filter filter,
                      GranularityFactory granularityFactory,
                      List<AggregatorFactory> aggregator,
                      List<PostAggregatorFactory> postAggregator,
                      Map<String, Object> context,
                      Boolean descending) {
        super(dataSource, intervals, context, granularityFactory, filter);
//        this.filter = filter;
//        this.granularity = granularityFactory;
        this.aggregators = aggregator;
        this.postAggregators = postAggregator;
//        this.dataSource = dataSource;
//        this.intervals = intervals;
//        this.context = context;
        this.descending = descending;
    }
}
