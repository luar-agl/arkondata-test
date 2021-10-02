package com.raulagl.arkondatatest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataBusDTO {

    @JsonProperty
    private List<VehicleDTO> records;
    @JsonProperty
    private String sql;


}
