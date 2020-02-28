package io.edurt.hqjl.base.searchqueryspec;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "contains", value = Contains.class),
        @JsonSubTypes.Type(name = "insensitive_contains", value = InsensitiveContains.class),
        @JsonSubTypes.Type(name = "fragment", value = Fragment.class),
        @JsonSubTypes.Type(name = "regex", value = Regex.class)

})
public interface SearchQueryFactory {
}
