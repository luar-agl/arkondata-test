package com.raulagl.arkondatatest.controllers;


import com.raulagl.arkondatatest.dto.ResponseVehicleDTO;
import com.raulagl.arkondatatest.services.VehicleService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    VehicleController( VehicleService vehicleService ) {
        this.vehicleService = vehicleService;
    }

    /**
     * in charge of get all available units
     * @return List<ResponseVehicleDTO>
     */
    @Get( value = "/available" )
    public List<ResponseVehicleDTO> getVehiclesAvailable() {
        return this.vehicleService.getAllVehiclesAvailable();
    }

    /**
     *
     * @param townHallId
     * in charge of get all units that have been within a town hall
     * @return List<ResponseVehicleDTO>
     */
    @Get( value = "/findByTownHall/{townHallId}" )
    public List<ResponseVehicleDTO> getVehiclesByTownHall(Long townHallId) {
        return this.vehicleService.getAllVehiclesByTownHall( townHallId );
    }

    /**
     *
     * @param vehicleId
     * in charge of get a list of locations given the id of the vehicle
     * @return List<ResponseVehicleDTO>
     */
    @Get( value = "/locations/{vehicleId}" )
    public List<ResponseVehicleDTO> findLocationsByVehicleId(Long vehicleId) {
        return this.vehicleService.findLocationsByVehicleId( vehicleId );
    }

}
