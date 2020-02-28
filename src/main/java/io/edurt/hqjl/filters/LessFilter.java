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
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * <p> LessFilter </p>
 * <p> Description : LessFilter </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-09 10:22 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@Builder
@ToString
public class LessFilter implements Filter {

    @Getter
    @JsonProperty(value = "dimension")
    private final String dimension;

    @Getter
    @JsonProperty(value = "upper")
    private final String upper;

    @Getter
    @JsonProperty(value = "upperStrict")
    private final Boolean upperStrict;

    @Getter
    @JsonProperty(value = "alphaNumeric")
    private final Boolean alphaNumeric;

    @JsonCreator
    public LessFilter(@JsonProperty("dimension") String dimension,
                      @JsonProperty("upper") String upper,
                      @JsonProperty("upperStrict") Boolean upperStrict,
                      @JsonProperty("alphaNumeric") Boolean alphaNumeric) {
        this.dimension = dimension;
        this.upper = upper;
        this.upperStrict = (upperStrict == null) ? false : upperStrict;
        this.alphaNumeric = (alphaNumeric == null) ? false : alphaNumeric;
    }

}
