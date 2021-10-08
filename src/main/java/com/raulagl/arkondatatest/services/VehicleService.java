package com.raulagl.arkondatatest.services;

import com.raulagl.arkondatatest.domain.Vehicle;
import com.raulagl.arkondatatest.dto.ResponseVehicleDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<ResponseVehicleDTO> getAllVehiclesAvailable();

    List<ResponseVehicleDTO> getAllVehiclesByTownHall( Long id );

    long count();

    void save( Vehicle vehicle );

    Optional<Vehicle> findByIdProvided(Long idProvided );

    List<ResponseVehicleDTO> findLocationsByVehicleId(Long vehicleId );
}
