package com.raulagl.arkondatatest.services;

import com.raulagl.arkondatatest.domain.Vehicle;
import com.raulagl.arkondatatest.dto.ResponseVehicleDTO;

import java.util.List;

public interface VehicleService {

    List<ResponseVehicleDTO> getAllVehiclesAvailable();

    List<ResponseVehicleDTO> getAllVehiclesByTownHall( Long id );

    long count();

    void save( Vehicle vehicle );
}
