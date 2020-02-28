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
import io.edurt.hqjl.base.Query;
import io.edurt.hqjl.base.granularity.GranularityFactory;
import io.edurt.hqjl.filters.Filter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;
/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-02-27 16:40
 */
@Data
@ToString
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TopN extends Query {

    @JsonProperty(value = "dimension")
    private String dimension;

    @JsonProperty(value = "metric")
    private String metric;

    @Builder.Default
    @JsonProperty(value = "threshold")
    private Integer threshold = 100;

    @Singular
    @JsonProperty(value = "aggregations")
    private List<AggregatorFactory> aggregators; // 聚集体

    @Singular
    @JsonProperty(value = "postAggregations")
    private List<PostAggregatorFactory> postAggregators; // 后续聚集体

    public TopN(String dataSource,
                List<String> intervals,
                Filter filter,
                GranularityFactory granularityFactory,
                List<AggregatorFactory> aggregator,
                List<PostAggregatorFactory> postAggregator,
                Map<String, Object> context,
                String dimension,
                String metric,
                Integer threshold) {
        super(dataSource, intervals, context, granularityFactory, filter);

        this.aggregators = aggregator;
        this.postAggregators = postAggregator;
        this.dimension = dimension;
        this.metric = metric;
        this.threshold = threshold;
    }

    public TopN(String dataSource,
                List<String> intervals,
                Filter filter,
                GranularityFactory granularityFactory,
                List<AggregatorFactory> aggregator,
                List<PostAggregatorFactory> postAggregator,
                Map<String, Object> context,
                String dimension,
                String metric) {
        super(dataSource, intervals, context, granularityFactory, filter);

        this.aggregators = aggregator;
        this.postAggregators = postAggregator;
        this.dimension = dimension;
        this.metric = metric;
    }
}
