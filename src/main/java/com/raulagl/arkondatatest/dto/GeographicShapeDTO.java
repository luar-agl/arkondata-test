package com.raulagl.arkondatatest.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeographicShapeDTO {

    // type of coordinates polygon or point (at the moment)
    private String type;

    // structure of the coordinates in response of public data cdmx - is recommended handle with flatmap
    private List<List<List<Double>>> coordinates;
}
