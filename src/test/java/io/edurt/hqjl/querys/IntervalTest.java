package io.edurt.hqjl.querys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edurt.hqjl.base.Query;
import io.edurt.hqjl.base.Query2;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

/**
 * @program: incubator-hqjl
 * @description:
 * @author: zns
 * @create: 2020-03-02 13:44
 */
public class IntervalTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void intervalTest() throws JsonProcessingException {
        Interval interval = new Interval(0, 1583127980535L);
        System.out.println(interval);
        System.out.println(objectMapper.writeValueAsString(interval));
        System.out.println(objectMapper.writeValueAsString(interval.toString()));
    }

    @Test
    public void intervalSql() throws JsonProcessingException {
        Interval interval = new Interval(0, 1583127980535L);
        Query2 query2 = Query2.builder().interval(interval).build();
        System.out.println(objectMapper.writeValueAsString(interval));
        System.out.println(objectMapper.writeValueAsString(query2));

    }

    @Test
    public void intervalYearTest() throws JsonProcessingException {
        Integer thisyear = DateTime.now().getYear();
        Integer startTime = DateTime.now().getYear();
        Integer endTime = startTime + 1;
        String times = startTime + "/" + endTime;

        System.out.println(thisyear);
        System.out.println(thisyear+1);
        Interval interval = new Interval(times);
        System.out.println(interval);
        System.out.println(objectMapper.writeValueAsString(interval));
        System.out.println(objectMapper.writeValueAsString(interval.toString()));
    }

}