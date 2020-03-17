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
package io.edurt.hqjl.postaggregators;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * <p> PostAggregatorFactory </p>
 * <p> Description : PostAggregatorFactory </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 18:29 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "arithmetic", value = ArithmeticPostAggregator.class),
        @JsonSubTypes.Type(name = "constant", value = ConstantPostAggregator.class),
        @JsonSubTypes.Type(name = "fieldAccess", value = FieldAccessorPostAggregator.class),
        @JsonSubTypes.Type(name = "finalizingFieldAccess", value = FieldAccessorPostAggregator.class),
        @JsonSubTypes.Type(name = "doubleGreatest", value = DoubleGreatestPostAggregator.class),
        @JsonSubTypes.Type(name = "doubleLeast", value = DoubleLeastPostAggregator.class),
        @JsonSubTypes.Type(name = "longGreatest", value = LongGreatestPostAggregator.class),
        @JsonSubTypes.Type(name = "longLeast", value = LongLeastPostAggregator.class),
        @JsonSubTypes.Type(name = "javascript", value = JavaScriptPostAggregator.class),
        @JsonSubTypes.Type(name = "hyperUniqueCardinality", value = HyperUniquePostAggregator.class),
        @JsonSubTypes.Type(name = "thetaSketchEstimate", value = ThetaSketchEstimate.class),
        @JsonSubTypes.Type(name = "thetaSketchSetOp", value = ThetaSketchSetOp.class),
        @JsonSubTypes.Type(name = "thetaSketchToString", value = ThetaSketchToString.class),
})
public interface PostAggregatorFactory {
//    String getName();
}
