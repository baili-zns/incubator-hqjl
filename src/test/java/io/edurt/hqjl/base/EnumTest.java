package io.edurt.hqjl.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.base.granularity.StringGranularityEnum;
import org.junit.Test;

/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-02-28 17:26
 */
public class EnumTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void enumtest() throws JsonProcessingException {
//        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING,false);
//        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX,false);

//        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        System.out.println(mapper.writeValueAsString(
                Query.builder().granularity(
                StringGranularityEnum.all).build())
        );
        System.out.println(mapper.writeValueAsString(
                Query.builder().granularity(
                        StringGranularityEnum3.all).build())
        );
        System.out.println(mapper.writeValueAsString(
                Query2.builder().granularity(
                        StringGranularityEnum2.all).build())
        );

    }
}