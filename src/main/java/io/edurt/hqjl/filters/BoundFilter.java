package io.edurt.hqjl.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.edurt.hqjl.base.extractionFn.ExtractionFn;
import io.edurt.hqjl.base.sort.SortEnum;
import io.edurt.hqjl.serializer.SortEnumSerializer;
import lombok.*;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-03 16:10
 */
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoundFilter implements Filter {
    @JsonProperty(value = "dimension")
    private String dimension;

    @JsonProperty(value = "lower")
    private String lower;

    @JsonProperty(value = "upper")
    private String upper;

    @JsonProperty(value = "lowerStrict")
    private Boolean lowerStrict; //default: false

    @JsonProperty(value = "upperStrict")
    private Boolean upperStrict; //default: false

    @JsonProperty(value = "ordering")
    @JsonSerialize(using = SortEnumSerializer.class)
    private SortEnum ordering;

    @JsonProperty(value = "extractionFn")
    private ExtractionFn extractionFn;
}