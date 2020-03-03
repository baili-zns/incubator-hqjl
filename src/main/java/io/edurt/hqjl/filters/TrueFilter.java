package io.edurt.hqjl.filters;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: incubator-hqjl
 * @description: The true filter is a filter which matches all values. It can be used to temporarily disable other filters without removing the filter.
 * @author: zns
 * @create: 2020-02-28 13:10
 */
@ToString
@Builder
@NoArgsConstructor
public class TrueFilter implements Filter{
}