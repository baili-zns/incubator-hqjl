package io.edurt.hqjl.querys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.base.searchqueryspec.Contains;
import io.edurt.hqjl.filters.InFilter;
import io.edurt.hqjl.filters.SearchFilter;
import org.junit.Test;

import java.util.Arrays;

/**
 * @program: incubator-hqjl
 * @description: test
 * @author: zns
 * @create: 2020-02-27 16:40
 */
public class FilterTest {
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void inFilterTest() throws JsonProcessingException {
        InFilter inFilter = new InFilter("id", Arrays.asList());
        System.out.println(inFilter);
        System.out.println(mapper.writeValueAsString(inFilter));
    }

    @Test
    public void searchFilterTest() throws JsonProcessingException {
        SearchFilter searchFilter = SearchFilter.builder()
                .dimension("plateType")
//                .query(SearchQuery.builder().querytype("contains").value("01").build())
                .query(Contains.builder().value("01").build())
                .build();
        System.out.println(searchFilter);
        System.out.println(mapper.writeValueAsString(searchFilter));
    }
}