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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.edurt.hqjl.base.granularity.GranularityFactory;
import io.edurt.hqjl.filter.Filter;
import io.edurt.hqjl.type.GroupBy;
import io.edurt.hqjl.type.Timeseries;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.joda.time.Interval;

import java.util.List;
import java.util.Map;

/**
 * <p> QueryType </p>
 * <p> Description : QueryType </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 17:44 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "queryType")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "timeseries", value = Timeseries.class),
        @JsonSubTypes.Type(name = "groupBy", value = GroupBy.class)
})
public class Query {

    @JsonProperty(value = "dataSource")
    protected String dataSource; // 查询数据源

    @Singular
    @JsonProperty(value = "intervals")
    protected List<String> intervals; // 查询数据区间


    @JsonProperty(value = "context")
    protected Map<String, Object> context; // 额外配置信息

    @JsonProperty(value = "granularity")
    protected GranularityFactory granularity; // 查询粒度

    @JsonProperty(value = "filter")
    protected Filter filter; // 过滤条件

}
