package io.edurt.hqjl.querys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.base.granularity.StringGranularity;
import io.edurt.hqjl.base.granularity.StringGranularityEnum;
import io.edurt.hqjl.base.searchqueryspec.InsensitiveContains;
import io.edurt.hqjl.base.sort.SortEnum;
import org.junit.Test;

/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-02-28 15:36
 */
public class SearchTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void searchTest() throws JsonProcessingException {
        Search search = Search.builder()
                .dataSource("sample_datasource")
                .granularity(StringGranularityEnum.day)
                .searchDimension("dim1")
                .searchDimension("dim2")
                .query(new InsensitiveContains("Ke"))
                .sort(SortEnum.lexicographic)
                .interval("2013-01-01T00:00:00.000/2013-01-03T00:00:00.000")
                .build();
        System.out.println(mapper.writeValueAsString(search));
    }
}