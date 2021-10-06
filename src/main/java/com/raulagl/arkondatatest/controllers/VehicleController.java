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

    @Get( value = "/available" )
    public List<ResponseVehicleDTO> getVehiclesAvailable() {
        return this.vehicleService.getAllVehiclesAvailable();
    }

}
