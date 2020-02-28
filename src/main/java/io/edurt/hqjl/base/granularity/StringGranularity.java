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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import lombok.Getter;

import java.io.IOException;

/**
 * <p> Granularity </p>
 * <p> Description : Granularity </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2020-01-04 17:50 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
//@JsonSerialize(using = StdSerializer.class)
//@JsonIgnoreProperties(value = {"type","name"})//会导致jackson序列化出错
    @Deprecated
public class StringGranularity implements GranularityFactory, JsonSerializable {

    @Getter
    @JsonProperty(value = "granularity")
    private final StringGranularityEnum granularity; // 持续时间

    @JsonCreator
    public StringGranularity(
    ) {
        this.granularity = StringGranularityEnum.all;
    }

    @JsonCreator
    public StringGranularity(@JsonProperty("granularity") final StringGranularityEnum granularity
    ) {
        this.granularity = granularity;
    }

    @Override
    public String toString() {
        return this.granularity.name();
    }


    @Override
    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(this.granularity.name());
    }

    @Override
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.writeString(this.granularity.name());
    }
}
