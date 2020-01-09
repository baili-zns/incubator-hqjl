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

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edurt.hqjl.aggregator.AggregatorFactory;
import io.edurt.hqjl.aggregator.post.PostAggregatorFactory;
import io.edurt.hqjl.base.Granularity;
import io.edurt.hqjl.base.Query;
import io.edurt.hqjl.filter.Filter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * <p> GroupBy </p>
 * <p> Description : GroupBy </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-09 10:41 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class GroupBy extends Query {

    @JsonProperty(value = "dimensions")
    public List<String> dimensions;

    @JsonProperty(value = "aggregations")
    public List<AggregatorFactory> aggregators;

    @JsonProperty(value = "postAggregations")
    public List<PostAggregatorFactory> postAggregators;

    public GroupBy(String dataSource, List<String> dimensions, Granularity granularity, Filter filter,
                   List<AggregatorFactory> aggregators, List<PostAggregatorFactory> postAggregators,
                   List<String> intervals, Map<String, Object> context) {
        super();
        this.dataSource = dataSource;
        this.dimensions = dimensions;
        this.granularity = granularity;
        this.filter = filter;
        this.aggregators = aggregators;
        this.postAggregators = postAggregators;
        this.intervals = intervals;
        this.context = context;
    }

}
