package com.raulagl.arkondatatest.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raulagl.arkondatatest.client.DataCDMXApiClient;
import com.raulagl.arkondatatest.domain.TownHall;
import com.raulagl.arkondatatest.domain.Vehicle;
import com.raulagl.arkondatatest.dto.GeographicShapeDTO;
import com.raulagl.arkondatatest.dto.TownHallPolygonDTO;
import com.raulagl.arkondatatest.dto.VehicleDTO;
import com.raulagl.arkondatatest.mapper.util.ModelMapperUtils;
import com.raulagl.arkondatatest.repositories.TownHallRepository;
import com.raulagl.arkondatatest.services.LoadDataVehicleService;
import com.raulagl.arkondatatest.services.VehicleService;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Singleton
public class LoadDataVehicleServiceImpl implements LoadDataVehicleService {

    private final VehicleService vehicleService;
    private final DataCDMXApiClient dataCDMXApiClient;
    private final TownHallRepository townHallRepository;

    public LoadDataVehicleServiceImpl(
            VehicleService vehicleService,
            DataCDMXApiClient dataCDMXApiClient,
            TownHallRepository townHallRepository) {
        this.vehicleService = vehicleService;
        this.dataCDMXApiClient = dataCDMXApiClient;
        this.townHallRepository = townHallRepository;
    }



    @Override
    public void loadDataVehicles() {
        long size = this.vehicleService.count();

        if ( size == 0 ) {

            List<TownHallPolygonDTO> townHallPolygons =  this.generatePolygons();

            this.dataCDMXApiClient
                    .getDataOfBuses()
                    .getResult()
                    .getRecords()
                    .forEach( vehicleDTO -> this.saveVehicle( townHallPolygons, vehicleDTO) );
        }

    }

    @Override
    public void loadDataVehiclesJob() {

        List<TownHallPolygonDTO> townHallPolygons =  this.generatePolygons();

        this.dataCDMXApiClient
                .getDataOfBuses()
                .getResult()
                .getRecords()
                .forEach( vehicleDTO -> validateNewVehicle( vehicleDTO, townHallPolygons ) );
    }

    private void validateNewVehicle(VehicleDTO vehicleDTO, List<TownHallPolygonDTO> townHallPolygons) {

        Long idProvidedByApi = vehicleDTO.getIdProvided();

        Optional<Vehicle> vehicleOptional = this.vehicleService.findByIdProvided( idProvidedByApi );

        if ( !vehicleOptional.isPresent() ) {
            this.saveVehicle( townHallPolygons, vehicleDTO );
        }
    }


    private void saveVehicle(List<TownHallPolygonDTO> townHallPolygons, VehicleDTO vehicleDTO) {

        Optional<TownHallPolygonDTO> townHallPolygon = this.getTownHall( townHallPolygons, vehicleDTO );
        if ( townHallPolygon.isPresent() ) {
            TownHall townHall = townHallPolygon.get().getTownHall();
            Vehicle vehicle = ModelMapperUtils.map( vehicleDTO, Vehicle.class );
            vehicle.setTownHall( townHall );

            this.vehicleService.save( vehicle );
        } else {
            log.info( "This point is not in any town hall: " + vehicleDTO.getGeographicPoint() );
        }

    }

    /**
     *
     * @param townHallPolygons
     * @param vehicleDTO
     * find town hall according to points of lat/long
     * @return
     */
    private Optional<TownHallPolygonDTO> getTownHall(final List<TownHallPolygonDTO> townHallPolygons, final VehicleDTO vehicleDTO) {
        //  Lat = Y Long = X

        return townHallPolygons
                .stream()
                .filter( townHallPolygon -> this.findTownHallByLatitudeAndLongitude( townHallPolygon, vehicleDTO ) )
                .findFirst();

    }


    /**
     *
     * @param townHallPolygon
     * @param vehicleDTO
     * create a point and verify if this point is in the polygon of town hall
     * @return
     */
    private boolean findTownHallByLatitudeAndLongitude(TownHallPolygonDTO townHallPolygon, VehicleDTO vehicleDTO) {
        Double longitude = vehicleDTO.getPositionLongitude();
        Double latitude = vehicleDTO.getPositionLatitude();
        Point2D P2D2 = new Point2D.Double();
        P2D2.setLocation(longitude, latitude);
        return townHallPolygon.getPolygon().contains( P2D2 );
    }

    private List<TownHallPolygonDTO> generatePolygons() {
        return this.townHallRepository
                .findAll()
                .stream()
                .map( this::generatePolygon )
                .collect( Collectors.toList() );
    }

    private TownHallPolygonDTO generatePolygon(TownHall townHall) {
        Path2D polygon = this.readCoordinatesOfPolygon( townHall.getGeographicShape() );

        return new TownHallPolygonDTO( townHall, polygon );
    }

    private Path2D readCoordinatesOfPolygon(String geographicShape ) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            GeographicShapeDTO geographicShapeDTO =  mapper.readValue( geographicShape, GeographicShapeDTO.class );

            Path2D polygon = new Path2D.Double();
            polygon.moveTo( 0, 0);

            geographicShapeDTO
                    .getCoordinates()
                    .stream()
                    .flatMap( Collection::stream )
                    .forEach( v -> polygon.lineTo( v.get(0), v.get(1) ) );

            polygon.closePath();

            return polygon;

        } catch ( JsonProcessingException e ) {
            log.error( e.getMessage() );
            return null;
        }

    }

}
