package io.edurt.hqjl.base;


import com.fasterxml.jackson.annotation.*;
import io.edurt.hqjl.base.granularity.GranularityFactory;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-02-26 15:48
 */
//@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
//@JsonIgnoreProperties(value = {"type","name","id","@type","@class","StringGranularityEnum3"})
//@JsonInclude(JsonInclude.Include.NON_NULL)

public enum StringGranularityEnum3 implements GranularityFactory
{
    all, none, second, minute, fifteen_minute, thirty_minute, hour, day, week, month, quarter, year;

//    all("all"),
//    none("none"),
//    second("second"),
//    minute("minute"),
//    fifteen_minute("fifteen_minute"),
//    thirty_minute("thirty_minute"),
//    hour("hour"),
//    day("day"),
//    week("week"),
//    month("month"),
//    quarter("quarter"),
//    year("year");
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    @JsonProperty("type")
    @JsonIgnore
    private String type;

//
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private String id;
}