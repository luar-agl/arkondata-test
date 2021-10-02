package com.raulagl.arkondatatest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDTO {

    private Integer id;

    @JsonProperty( "_full_text" )
    private String  fullText;

    @JsonProperty( "_id" )
    private Integer beforeId;

    @JsonProperty( "date_updated" )
    private String dateUpdated;

    @JsonProperty("vehicle_id")
    private Integer vehicleId;

    @JsonProperty("vehicle_label")
    private String vehicleLabel;

    @JsonProperty("vehicle_current_status")
    private Integer vehicleCurrentStatus;

    @JsonProperty("position_latitude")
    private String positionLatitude;

    @JsonProperty("position_longitude")
    private String positionLongitude;

    @JsonProperty("geographic_point")
    private String geographicPoint;

    @JsonProperty("position_speed")
    private Integer positionSpeed;

    @JsonProperty("position_odometer")
    private Integer positionOdometer;

    @JsonProperty("trip_schedule_relationship")
    private Integer tripScheduleRelationship;

    @JsonProperty("trip_route_id")
    private Integer tripRouteId;


}
