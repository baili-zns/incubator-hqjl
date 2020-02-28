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
import io.edurt.hqjl.base.Query;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
public class Scan extends Query {

    @JsonProperty(value = "resultFormat")
    private String resultFormat;

    @JsonProperty(value = "batchSize")
    private Integer batchSize=20480;

    @Builder.Default
    @JsonProperty(value = "limit")
    private Integer limit = 100;

    @Builder.Default
    @JsonProperty(value = "order")
    private String order = "none";

    @Builder.Default
    @JsonProperty(value = "legacy")
    private Boolean legacy = false;

    @Singular
    @JsonProperty(value = "columns")
    private List<String> columns;

//    @Singular
//    @JsonProperty(value = "aggregations")
//    private List<AggregatorFactory> aggregators; // 聚集体
//
//    @Singular
//    @JsonProperty(value = "postAggregations")
//    private List<PostAggregatorFactory> postAggregators; // 后续聚集体
}
