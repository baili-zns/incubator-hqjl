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
import lombok.*;

/**
 * <p> Granularity </p>
 * <p> Description : Granularity </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 17:50 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@ToString
public class PeriodGranularity implements GranularityFactory {

    @Getter
    @JsonProperty(value = "period")
    private final String period; // 区间

    @Getter
    @JsonProperty(value = "timeZone")
    private final String timeZone; // 时区

    @Getter
    @JsonProperty(value = "origin")
    private final String origin; // 区间开始时间

    @JsonCreator
    public PeriodGranularity(@JsonProperty("period") final String period,
                             @JsonProperty("timeZone") final String timeZone
    ) {
        this.period = period;
        this.timeZone = timeZone;
        this.origin = null;
    }

    @JsonCreator
    public PeriodGranularity(@JsonProperty("period") final String period,
                             @JsonProperty("timeZone") final String timeZone,
                             @JsonProperty("origin") final String origin
    ) {
        this.period = period;
        this.timeZone = timeZone;
        this.origin = origin;
    }
}