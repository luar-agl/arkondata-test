package com.raulagl.arkondatatest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTownHallDTO {

    private Long id;

    private String name;

    private Integer keyMun;

    private Integer keyEnt;

    private Integer keyGeo;

    private Integer gid;

    private String geographicPoint2d;

}
