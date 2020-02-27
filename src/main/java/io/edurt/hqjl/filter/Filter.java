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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.jndi.toolkit.dir.SearchFilter;

/**
 * <p> Filter </p>
 * <p> Description : Filter </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 18:24 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "and", value = AndFilter.class),
        @JsonSubTypes.Type(name = "or", value = OrFilter.class),
        @JsonSubTypes.Type(name = "selector", value = SelectorFilter.class),
        @JsonSubTypes.Type(name = "in", value = InFilter.class),
        @JsonSubTypes.Type(name = "not", value = NotFilter.class),
        @JsonSubTypes.Type(name = "regex", value = RegexFilter.class),
        @JsonSubTypes.Type(name = "gt", value = GreaterFilter.class),
        @JsonSubTypes.Type(name = "lt", value = LessFilter.class),
        @JsonSubTypes.Type(name = "search", value = SearchFilter.class),
})
public interface Filter {
}
