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
package io.edurt.hqjl.base.granularity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

/**
 * <p> Granularity </p>
 * <p> Description : Granularity </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 17:50 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@ToString
public class DurationGranularity implements GranularityFactory {

    @Getter
    @JsonProperty(value = "duration")
    private final String duration; // 持续时间

    @Getter
    @JsonProperty(value = "origin")
    private final String origin; // 时区

    @JsonCreator
    public DurationGranularity(@JsonProperty("duration") final String duration
    ) {
        this.duration = duration;
        this.origin = null;
    }
    @JsonCreator
    public DurationGranularity(@JsonProperty("duration") final String duration,
                               @JsonProperty("origin") final String origin
    ) {
        this.duration = duration;
        this.origin = origin;
    }
}
