package com.raulagl.arkondatatest.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseVehicleDTO {


    private Long id;

    private Integer beforeId;

    private String dateUpdated;

    private Long vehicleId;

    private String vehicleLabel;

    private Integer vehicleCurrentStatus;

    private Double positionLatitude;

    private Double positionLongitude;

    private String geographicPoint;

    private Integer positionSpeed;

    private Integer positionOdometer;

    private Integer tripScheduleRelationship;

    private Integer tripRouteId;
}
