package io.edurt.hqjl.base.sort;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes(value = {
        @JsonSubTypes.Type(name = "type", value = SortEnum.class),
})
public enum SortEnum {
     alphanumeric, lexicographic, numeric, strlen, version;

//    alphanumeric("alphanumeric"),
//    lexicographic("lexicographic"),
//    numeric("numeric"),
//    strlen("strlen"),
//    version("version");
//
//
//    @Getter
//    @JsonProperty(value = "type")
//    private String type;
//
//    @JsonCreator
//    SortEnum(
//    ) {
//        this.type = SortEnum.valueOf("lexicographic").name();
//    }
//
//    @JsonCreator
//    SortEnum(@JsonProperty("type") final String sort
//    ) {
//        this.type = sort;
//    }
}
