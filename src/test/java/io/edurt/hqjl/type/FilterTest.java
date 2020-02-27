package io.edurt.hqjl.type;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.filter.InFilter;
import io.edurt.hqjl.filter.SearchFilter;
import io.edurt.hqjl.filter.SearchFilter.SearchQuery;
import lombok.ToString;
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
                .query(SearchQuery.builder().type("contains").value("01").build())
//                .query(new SearchQuery("contains","01"))
                .build();
        System.out.println(searchFilter);
        System.out.println(mapper.writeValueAsString(searchFilter));
    }
}