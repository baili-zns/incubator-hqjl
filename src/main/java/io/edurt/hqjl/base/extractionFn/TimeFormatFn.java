package io.edurt.hqjl.base.extractionFn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edurt.hqjl.base.granularity.GranularityFactory;
import io.edurt.hqjl.base.granularity.StringGranularityEnum;
import io.edurt.hqjl.filters.Filter;
import lombok.*;
import org.joda.time.format.DateTimeFormat;
import sun.util.resources.TimeZoneNames;

import java.util.List;
import java.util.TimeZone;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-03 15:20
 */
@Builder
@ToString
public class TimeFormatFn implements ExtractionFn {
    @JsonProperty(value = "format")
    private String format;

    @JsonProperty(value = "timeZone")
    private String timeZone;

    @JsonProperty(value = "locale")
    private String locale;

    @JsonProperty(value = "granularity")
    private GranularityFactory granularity;

    @JsonProperty(value = "asMillis")
    private Boolean asMillis;

    /*
    {
    "type" : "timeFormat",
    "format" : "EEEE",
    "timeZone" : "America/Montreal",
    "locale" : "fr"
  }
    */

}