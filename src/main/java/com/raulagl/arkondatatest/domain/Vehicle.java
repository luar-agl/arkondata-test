package com.raulagl.arkondatatest.domain;

import javax.persistence.*;
import java.util.Date;



@Table( name = "vehicle" )
@Entity
public class Vehicle {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "vehicle_generator")
    @SequenceGenerator( name = "vehicle_generator", sequenceName = "vehicle_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column( name = "id_provided")
    private Long idProvided;


    @Column( name = "full_text" )
    private String  fullText;

    @Column( name = "date_updated" )
    private Date dateUpdated;

    @Column( name = "vehicle_id")
    private Long vehicleId;

    @Column( name = "vehicle_label")
    private String vehicleLabel;

    @Column( name = "vehicle_current_status")
    private Integer vehicleCurrentStatus;

    @Column( name = "position_latitude")
    private Double positionLatitude;

    @Column( name = "position_longitude")
    private Double positionLongitude;

    @Column( name = "geographic_point")
    private String geographicPoint;

    @Column( name = "position_speed")
    private Integer positionSpeed;

    @Column( name = "position_odometer")
    private Integer positionOdometer;

    @Column( name = "trip_schedule_relationship")
    private Integer tripScheduleRelationship;

    @Column( name = "trip_route_id")
    private Integer tripRouteId;

    @ManyToOne
    @JoinColumn( name = "town_hall_id" )
    private TownHall townHall;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProvided() {
        return idProvided;
    }

    public void setIdProvided(Long idProvided) {
        this.idProvided = idProvided;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleLabel() {
        return vehicleLabel;
    }

    public void setVehicleLabel(String vehicleLabel) {
        this.vehicleLabel = vehicleLabel;
    }

    public Integer getVehicleCurrentStatus() {
        return vehicleCurrentStatus;
    }

    public void setVehicleCurrentStatus(Integer vehicleCurrentStatus) {
        this.vehicleCurrentStatus = vehicleCurrentStatus;
    }

    public Double getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(Double positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    public Double getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(Double positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    public String getGeographicPoint() {
        return geographicPoint;
    }

    public void setGeographicPoint(String geographicPoint) {
        this.geographicPoint = geographicPoint;
    }

    public Integer getPositionSpeed() {
        return positionSpeed;
    }

    public void setPositionSpeed(Integer positionSpeed) {
        this.positionSpeed = positionSpeed;
    }

    public Integer getPositionOdometer() {
        return positionOdometer;
    }

    public void setPositionOdometer(Integer positionOdometer) {
        this.positionOdometer = positionOdometer;
    }

    public Integer getTripScheduleRelationship() {
        return tripScheduleRelationship;
    }

    public void setTripScheduleRelationship(Integer tripScheduleRelationship) {
        this.tripScheduleRelationship = tripScheduleRelationship;
    }

    public Integer getTripRouteId() {
        return tripRouteId;
    }

    public void setTripRouteId(Integer tripRouteId) {
        this.tripRouteId = tripRouteId;
    }

    public TownHall getTownHall() {
        return townHall;
    }

    public void setTownHall(TownHall townHall) {
        this.townHall = townHall;
    }
}
