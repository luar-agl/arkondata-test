package com.raulagl.arkondatatest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TownHallDTO {


    @JsonProperty( "_id" )
    private Integer idProvided;

    @JsonProperty( "_full_text" )
    private String fullText;

    @JsonProperty( "nomgeo" )
    private String name;

    @JsonProperty( "cve_mun" )
    private Integer keyMun;

    @JsonProperty( "cve_ent" )
    private Integer keyEnt;

    @JsonProperty( "cvegeo" )
    private Integer keyGeo;

    @JsonProperty( "gid" )
    private Integer gid;

    @JsonProperty( "geo_point_2d" )
    private String geographicPoint2d;

    @JsonProperty( "geo_shape" )
    private String geographicShape;

}
