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
package io.edurt.hqjl.aggregators;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
public class AggregatorThetaSketch implements AggregatorFactory {

    @Getter
    @JsonProperty(value = "name")
    private final String name;

    @Getter
    @JsonProperty(value = "fieldName")
    private final String fieldName;

    @JsonCreator
    public AggregatorThetaSketch(@JsonProperty("name") String name,
                                 @JsonProperty("fieldName") final String fieldName) {
        this.name = name;
        this.fieldName = fieldName;
    }

}
