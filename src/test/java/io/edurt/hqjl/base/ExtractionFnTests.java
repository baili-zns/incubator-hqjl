package io.edurt.hqjl.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableMap;
import io.edurt.hqjl.base.extractionFn.CustomExtractionFn;
import io.edurt.hqjl.base.extractionFn.TimeFormatFn;
import io.edurt.hqjl.filters.SelectorFilter;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-03 15:54
 */
public class ExtractionFnTests {
    public static ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void customFnTest() throws JsonProcessingException {
        CustomExtractionFn customExtractionFn = CustomExtractionFn.builder()
                .content("a", 1)
                .content("b", 2)
                .contents(ImmutableMap.<String, String>builder()
                        .put("k1", "v1")
                        .put("k2", "v2").build())
                .build();
        System.out.println(objectMapper.writeValueAsString(customExtractionFn));
        SelectorFilter selectorFilter = SelectorFilter.builder()
                .extractionFn(TimeFormatFn.builder().build())
                .build();
        System.out.println(objectMapper.writeValueAsString(selectorFilter));
    }
}