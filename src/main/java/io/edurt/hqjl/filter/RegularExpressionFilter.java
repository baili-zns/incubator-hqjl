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
package io.edurt.hqjl.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
public class RegularExpressionFilter implements Filter {

    @Getter
    @JsonProperty(value = "dimension")
    private final String dimension;

    @Getter
    @JsonProperty(value = "pattern")
    private final String pattern;

    @JsonCreator
    public RegularExpressionFilter(@JsonProperty(value = "dimension") String dimension,
                                   @JsonProperty(value = "pattern") String pattern) {
        this.dimension = dimension;
        this.pattern = pattern;
    }

}
