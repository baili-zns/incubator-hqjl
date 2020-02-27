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
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * <p> SelectorFilter </p>
 * <p> Description : SelectorFilter </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-09 10:28 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@ToString
@SuperBuilder(toBuilder = true)
public class SearchFilter implements Filter {

    @ToString
    @SuperBuilder(toBuilder = true)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
    public static class SearchQuery {
        @Getter
        @JsonProperty(value = "type")
        protected final String type;
        @Getter
        @JsonProperty(value = "value")
        protected final String value;

        public SearchQuery(String type, String value) {
            this.type = type;
            this.value = value;
        }
    }

    @Getter
    @JsonProperty(value = "dimension")
    private final String dimension;

    @Getter
    @JsonProperty(value = "query")
    private final SearchQuery query;


    @JsonCreator
    public SearchFilter(@JsonProperty(value = "dimension") String dimension, SearchQuery query) {
        this.dimension = dimension;
        this.query = query;
    }

}
