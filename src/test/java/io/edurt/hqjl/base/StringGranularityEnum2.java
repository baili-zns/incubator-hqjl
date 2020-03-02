package io.edurt.hqjl.base;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-02-26 15:48
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.WRAPPER_OBJECT)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
//@JsonSubTypes(value = {
//        @JsonSubTypes.Type(name = "type", value = StringGranularityEnum2.class),
//})
public enum StringGranularityEnum2
{
    all, none, second, minute, fifteen_minute, thirty_minute, hour, day, week, month, quarter, year;
}