package com.raulagl.arkondatatest.dto;

import com.raulagl.arkondatatest.domain.TownHall;
import lombok.Getter;

import java.awt.geom.Path2D;



@Getter
public class TownHallPolygonDTO {

    private final TownHall townHall;
    private final Path2D polygon;

    /*
     * @constructor with the parameters for secure a couple of town hall and polygon
     */
    public TownHallPolygonDTO(TownHall townHall, Path2D polygon) {
       this.polygon = polygon;
       this.townHall = townHall;
    }
}
