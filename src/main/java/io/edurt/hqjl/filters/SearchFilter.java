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
package io.edurt.hqjl.filters;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.edurt.hqjl.base.searchqueryspec.SearchQueryFactory;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@ToString
@SuperBuilder(toBuilder = true)
public class SearchFilter implements Filter {

    @Getter
    @JsonProperty(value = "dimension")
    private final String dimension;

    @Getter
    @JsonProperty(value = "query")
    private final SearchQueryFactory query;


    @JsonCreator
    public SearchFilter(@JsonProperty(value = "dimension") String dimension, SearchQueryFactory query) {
        this.dimension = dimension;
        this.query = query;
    }

}
