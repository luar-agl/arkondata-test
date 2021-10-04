package com.raulagl.arkondatatest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseDataCDMXDTO<T> {

    @JsonProperty
    private String help;
    @JsonProperty
    private Boolean success;
    @JsonProperty
    private DataCDMXDTO<T> result;
}
